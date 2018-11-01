<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.tf.domain.*" %>
<%
Users user=(Users)session.getAttribute("users");
String name=user.getName();
List<Orders> orders=(List<Orders>)session.getAttribute("orders");
System.out.println(orders.get(0).getOrderId());

int numbook=(int)session.getAttribute("numbook");
Books[] cbook=new Books[numbook];
String[] ctitle=new String[numbook];
String[] cprice=new String[numbook];
System.out.println(numbook);

String[] count=new String[numbook];
count=(String[])session.getAttribute("count");
double sum=0;
for(int i=0;i<numbook;i++){
	cbook[i]=(Books)session.getAttribute("cbook"+i);
	ctitle[i]=cbook[i].getTitle();
	cprice[i]=cbook[i].getUnitPrice();
	
	int a=Integer.parseInt(count[i]);
	System.out.println(a);
	double b=Double.parseDouble(cprice[i]);
	System.out.println(b);
	sum=a*b+sum;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
						
						<li><a href="account.jsp"><i class="fa fa-user-o"></i><%=name %></a></li>
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
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li><a href="index.jsp">主页</a></li>
						<li class="active"><a href="#">个人信息</a></li>
						<li><a href="changePw.jsp">修改密码</a></li>
						<li><a href="#">查看订单</a></li>
						
					</ul>
					<!-- /NAV -->
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
							<li><a href="#">账户管理</a></li>
							<li class="active">账户信息一览</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

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


<div>
<table class="table">
	<caption>历史订单</caption>
   <thead>
      <tr>
      	 <th>OrderId</th>
         <th>OrderDate</th>
         <th>TotalPrice</th>
         <th>PostAddreass</th>
         
         
      </tr>
   </thead>
   <tbody>
   <% 
      for(int i=0;i<orders.size();i++){
      %>
      <tr>
     
      
         <td><%=orders.get(i).getOrderId() %></td>
         <td><%=orders.get(i).getOrderDate() %></td>
         <td><%=orders.get(i).getTotalPrice() %></td>
         <td><%=orders.get(i).getPostAddress() %></td>
      
         
         
      </tr>
      
         <%
         }
         %>
   </tbody>
</table>
</div>


























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
									<li><a href="#">热销产品</a></li>
									<li><a href="#">Laptops</a></li>
									<li><a href="#">Smartphones</a></li>
									<li><a href="#">Cameras</a></li>
									<li><a href="#">Accessories</a></li>
								</ul>
							</div>
						</div>

						<div class="clearfix visible-xs"></div>

						

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">服务</h3>
								<ul class="footer-links">
									<li><a href="#">我的账户</a></li>
									<li><a href="#">购物车</a></li>
									<li><a href="#">收藏</a></li>
									<li><a href="#">追踪订单</a></li>
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
