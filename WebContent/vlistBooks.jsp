<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.tf.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String pages=request.getParameter("page");
int totalnum=(int)session.getAttribute("totalnum");
int totalpagess=totalnum/9;

int a=Integer.parseInt(pages);
Books[] book=new Books[totalnum];
book=(Books[])session.getAttribute("book");
String[] title=new String[totalnum];
String[] price=new String[totalnum];
for(int i=0;i<totalnum;i++){
	
	 title[i]=book[i].getTitle();
	 price[i]=book[i].getUnitPrice();
}


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
						<li><a href="login.jsp"><i class="fa fa-user-o"></i>登入</a></li>
						<li><a href="regist.jsp"><i class="fa fa-user-o"></i>注册</a></li>
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
						<ul class="breadcrumb-tree">
							<li><a href="index.jsp">Home</a></li>							
							<li class="active">Result (<%=totalnum%> Results)</li>
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
					<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Categories</h3>
							<form action="${pageContext.request.contextPath}/servlet/UserServlet?op=listBookByCategory&inputC=CategoryId" method="post">
							

								<div class="radio">
   <label for="">
    <input type="radio" name="input" id="optionsRadios1" 
    value="1" >C#
   </label>
  </div>
  <div class="radio">
   <label for="">
    <input type="radio" name="input" id="optionsRadios1" 
    value="25" >.NET
   </label>
  </div>
  <div class="radio">
   <label for="">
    <input type="radio" name="input" id="optionsRadios1" 
    value="31" >JSP
   </label>
  </div>
  <div class="radio">
   <label for="">
    <input type="radio" name="input" id="optionsRadios1" 
    value="15" >C++
   </label>
  </div>
 
 
							
							 <button type="submit" class="primary-btn">Search</button>
							</form>
						</div>
						<!-- /aside Widget -->

						

			

						
					</div>
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						
						

						<!-- store products -->
						<div class="row" height="460" width="200">
						<%						
	for(int i=(a-1)*9;i<a*9;i++){

%>
						
							<!-- product -->
							<div class="col-md-4 col-xs-6"  >
								<div class="product">
									<div class="product-img">
									<%String src="./img/"+book[i].getId()+".jpg"; %>
										<img src=<%=src %> alt="" height="400" width="200">									
									</div>
									<div class="product-body" style='border:0px;padding:3px; PADDING:0px;  height:95px; LINE-HEIGHT: 20px;  '>
										<p class="product-category">Category</p>
										<% String herf="servlet/UserServlet?op=show&vop=y&bookid="+book[i].getId(); %>
										<div class="product-name" ><a href=<%=herf %> ><%=title[i] %></a></div>
										<h4 class="product-price"><%=book[i].getUnitPrice() %> </h4>																			
									</div>
									<div class="add-to-cart">
										<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>
								</div>
							</div>
							<!-- /product -->
<%} %>
		
						
						<!-- /store products -->

						<!-- store bottom filter -->
						<div align="center">
                              <ul class="pagination" id="paginator"></ul>
                          </div>						
						<!-- /store bottom filter -->
					</div>
					<!-- /STORE -->
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

                          
                               
       
    
         <script type='text/javascript'>
            var options = {
                    
                    bootstrapMajorVersion: 3,    //bootstrap版本
                    size: 'normal',
                    itemTexts: function (type, page, current) {
                        switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "<i class='fa fa-caret-left'></i> 上一页";
                        case "next":
                            return "下一页 <i class='fa fa-caret-right'></i>";
                        case "last":
                            return "末页";
                        case "page":
                            return page;
                        }
                    },
                    tooltipTitles: function (type, page, current) {
                        switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "上一页";
                        case "next":
                            return "下一页";
                        case "last":
                            return "末页";
                        case "page":
                            return "第" + page + "页";
                        }
                    },
                    pageUrl: function(type, page, current){
                        return "listBooks.jsp?page="+page;    //跳转到选定页面
                    },
                    numberOfPages: 5,    //显示“第几页”的选项数目
                    currentPage: <%=a %>,    //当前页数
                    totalPages: <%=totalpagess %>    //总页数
                   }
    
            $('#paginator').bootstrapPaginator(options);
        </script>
 
	</body>
</html>
