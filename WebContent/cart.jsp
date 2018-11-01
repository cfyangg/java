<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.tf.domain.*" %>
<%
int numbook=(int)session.getAttribute("numbook");
Books[] cbook=new Books[numbook];
String[] ctitle=new String[numbook];
String[] cprice=new String[numbook];
String[] cbookid=new String[numbook];
System.out.println(numbook);

String[] count=new String[numbook];
count=(String[])session.getAttribute("count");
double sum=0;
for(int i=0;i<numbook;i++){
	cbook[i]=(Books)session.getAttribute("cbook"+i);
	ctitle[i]=cbook[i].getTitle();
	cprice[i]=cbook[i].getUnitPrice();
	cbookid[i]=cbook[i].getId();
	
	
	int a=Integer.parseInt(count[i]);
	System.out.println(a);
	double b=Double.parseDouble(cprice[i]);
	System.out.println(b);
	sum=a*b+sum;
	
	
}
Users user=(Users)session.getAttribute("users");
String name1=user.getName();
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro - HTML Ecommerce Template</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link rel="stylesheet" href="./css/bootstrapv3.css">
 		<script src="./js/jquery-1.9.1.min.js"></script>
 		<script src="./js/bootstrap.min.js"></script>
		<script src="./js/bootstrap-paginator.min.js"></script>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> 538538538</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> 538538538@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 9舍538</a></li>
					</ul>
					<ul class="header-links pull-right">
						
						<li><a href="account.jsp"><i class="fa fa-user-o"></i><%=name1 %></a></li>
						<li><a href="servlet/UserServlet?op=logout"><i class="fa fa-user-o"></i>退出</a></li>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="#" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form action="${pageContext.request.contextPath}/servlet/UserServlet?op=listBookByCategory" method="post">
									<select class="input-select" id="inputC" name="inputC">
										<option  value="Title">By Title</option>
										<option  value="ISBN">By ISBN</option>
										
									</select>
									<input class="input" id="input" name="input" placeholder="Search here">
									<button type="submit" class="search-btn">Search</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
										<div class="qty"><%=numbook %></div>
									</a>
									
									
									<div class="cart-dropdown">
									
										<div class="cart-list">
											<%
										for(int i=0;i<numbook;i++){
											String purl="./img/"+cbook[i].getId()+".jpg";
											String durl="servlet/UserServlet?op=deleteCart&bookid="+cbook[i].getId();
									%>
											<div class="product-widget">
										
												<div class="product-img">
													<img src=<%=purl %> alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#"><%=ctitle[i] %></a></h3>
													<h4 class="product-price"><span class="qty"><%=count[i] %>x</span><%=cprice[i] %></h4>
												</div>
												<a href=<%=durl %>><button class="delete"><i class="fa fa-close"></i></button></a>
												
											</div>
											<%
										       }
												%>
											</div>
									
											
										<div class="cart-summary">
											<small><%=numbook %> Item(s) selected</small>
											<h5>SUBTOTAL:<%=sum %></h5>
										</div>
										<div class="cart-btns">
											<a href="cart.jsp">View Cart</a>
											<a href="cart.jsp">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->

		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">Regular Page</h3>
						<ul class="breadcrumb-tree">
							<li><a href="#">Home</a></li>
							<li class="active">Blank</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

<form action="${pageContext.request.contextPath}/checkout.jsp?op=addorder" method="post">
<table class="table">
	<caption>购物车</caption>
   <thead>
      <tr>
         <th>Title</th>
         <th>Count</th>
         <th>Price</th>
         <th>Choose</th>
         
      </tr>
   </thead>
   <tbody>
   <%
	for(int i=0;i<numbook;i++)
	{
	%>
      <tr>
         <td><%=ctitle[i] %></td>
         <td><%=count[i] %></td>
         <td><%=cprice[i] %></td>
         <%
         String name="choose"+i;
         %>
         <td><input name=<%=name %> value=<%=i %> type="checkbox"></td>
      </tr>
      <%
      } 
      %>
   </tbody>
</table>
<button class="primary-btn" type="submit" >结算</button>
</form>















		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- NEWSLETTER -->
		<div id="newsletter" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="newsletter">
							<p>Sign Up for the <strong>NEWSLETTER</strong></p>
							<form>
								<input class="input" type="email" placeholder="Enter Your Email">
								<button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
							</form>
							<ul class="newsletter-follow">
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-instagram"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-pinterest"></i></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /NEWSLETTER -->

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Categories</h3>
								<ul class="footer-links">
									<li><a href="servlet/Userservlet?op=Hd">热销产品</a></li>
									<li><a href="servlet/Userservlet?op=listBookByCategory&inputC=CategoryId&input=1">C#</a></li>
									<li><a href="servlet/Userservlet?op=listBookByCategory&inputC=CategoryId&input=38">电子商务</a></li>
									<li><a href="servlet/Userservlet?op=listBookByCategory&inputC=CategoryId&input=25">.NET</a></li>
									<li><a href="#">Accessories</a></li>
								</ul>
							</div>
						</div>

						<div class="clearfix visible-xs"></div>

						

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">服务</h3>
								<ul class="footer-links">
									<li><a href="account.jsp">我的账户</a></li>
									<li><a href="cart.jsp">购物车</a></li>
									
									<li><a href="servlet/UserServlet?op=listOrders">追踪订单</a></li>
									<li><a href="#">帮助</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

			<!-- bottom footer -->
			<div id="bottom-footer" class="section">
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-12 text-center">
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
							</ul>
							<span class="copyright">
								
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by Colorlib  -  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
							
							</span>


						</div>
					</div>
						<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /bottom footer -->
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>

	</body>
</html>