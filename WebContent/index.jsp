<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.tf.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Books[] book=new Books[10];
String[] title=new String[10];
String[] price=new String[10];
for(int i=0;i<10;i++){
	book[i]=(Books)session.getAttribute("book"+i);
	 title[i]=book[i].getTitle();
	 price[i]=book[i].getUnitPrice();
}
%>

<%
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
Users user=(Users)session.getAttribute("users");
String name=user.getName();




System.out.println(count[0]);


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
 	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
						<li class="active"><a href="#">Home</a></li>
						<li><a href="servlet/UserServlet?op=hd">Hot Deals</a></li>						
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop0111.jpg" alt="" height="300" width="200">
							</div>
							<div class="shop-body">
								<h3>asp<br>Collection</h3>
								<a href="servlet/UserServlet?op=listBookByCategory&inputC=CategoryId&input=29" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/002.png" alt="" height="300" width="200">
							</div>
							<div class="shop-body">
								<h3>c#<br>Collection</h3>
								<a href="servlet/UserServlet?op=listBookByCategory&inputC=CategoryId&input=1" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/003.png" alt="" height="300" width="200">
							</div>
							<div class="shop-body">
								<h3>C++<br>Collection</h3>
								<a href="servlet/UserServlet?op=listBookByCategory&inputC=CategoryId&input=15" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">



					<!-- Products tab & slick -->
					<div class="col-md-12">
					<h3 class="title">Top selling</h3>
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
										<%for(int i=0;i<5;i++){
											String src="./img/"+book[i].getId()+".jpg";
											
											%>
										
										<div class="product">
											<div class="product-img">
												<img src=<%=src %> alt="" height="400" width="200">
												
											</div>
											<div class="product-body">
												<p class="product-category">Category</p>
												<% String herf="servlet/UserServlet?op=show&bookid="+book[i].getId(); %>
											<div class="product-name" ><a href=<%=herf %> ><%=title[i] %></a></div>
												<h4 class="product-price"><%=price[i] %> </h4>
											
												
											</div>
											<div class="add-to-cart">
											<%String url="servlet/UserServlet?op=addcart&bookid="+book[i].getId(); %>
												<a href=<%=url %>><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
											</div>
										</div>
										<%
										}
										%>
										<!-- /product -->

										
									</div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							
							<h2 class="text-uppercase">hot deal this week</h2>
							<p>New Collection Up to 50% OFF</p>
							<a class="primary-btn cta-btn" href="servlet/UserServlet?op=hd">Shop now</a>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>

		

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

	

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<h3 class="title">New Products</h3>
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab2" class="tab-pane fade in active">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<%for(int i=5;i<10;i++){
											String src="./img/"+book[i].getId()+".jpg";
											
											%>
										
										<div class="product">
											<div class="product-img">
												<img src=<%=src %> alt="" height="400" width="200">
												
											</div>
											<div class="product-body">
												<p class="product-category">Category</p>
												<% String herf="servlet/UserServlet?op=show&bookid="+book[i].getId(); %>
										<div class="product-name" ><a href=<%=herf %> ><%=title[i] %></a></div>
												<h4 class="product-price"><%=price[i] %> </h4>
											
												
											</div>
											<div class="add-to-cart">
												<%String url="servlet/UserServlet?op=addcart&bookid="+book[i].getId(); %>
												<a href=<%=url %>><button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
											</div>
										</div>
										<%
										}
										%>
										<!-- /product -->
										
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		

		

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">About Us</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
								<ul class="footer-links">
									<li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
									<li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
									<li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">Service</h3>
								<ul class="footer-links">
									<li><a href="account.jsp">My Account</a></li>
									<li><a href="cart.jsp">View Cart</a></li>
									
									<li><a href="listOrders.jsp">Track My Order</a></li>
									<li><a href="#">Help</a></li>
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
