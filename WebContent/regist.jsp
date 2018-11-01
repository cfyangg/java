<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-map-marker"></i>南京理工大学</a></li>
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
				
						<h3 class="breadcrumb-header">注册</h3>
						<ul class="breadcrumb-tree">
							<li><a href="#">注册</a></li>
							<li class="active">Blank</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->
		
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
		
		
		
		
		
		
		
		
    <h3>新用户注册</h3>
    <form action="${pageContext.request.contextPath}/servlet/UserServlet?op=userRegist" method="post">
    	
    	
    	<label for="pwd">姓名:</label>
      <input type="text" class="form-control" id="password" name="Name">
    	<label for="pwd">用户名:</label>
      <input type="text" class="form-control" id="password" name="LoginId">
      <label for="pwd">密码:</label>
      <input type="text" class="form-control" id="password" name="LoginPwd">
    	<label for="pwd">电话:</label>
      <input type="text" class="form-control" id="password" name="Phone">
      <label for="pwd">地址:</label>
      <input type="text" class="form-control" id="password" name="Address">
    	<button type="submit" class="primary-btn">注册</button>
    	
    	
    	
    	
    </form>
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
						
							<div class="footer" align="center">
								<h3 class="footer-title" >关于我们</h3>
								<ul class="footer-links" >
									
									<li><a href="#">地址：9舍538</a></li>
									<li><a href="#">联系电话：538538538</a></li>
						
									<li><a href="#">合作</a></li>
								</ul>
							</div>
							
						</div>

						<div class="clearfix visible-xs"></div>

						

					
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

			<!-- bottom footer -->
			
			<div id="bottom-footer" class="section">
				<div class="container">
					
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
