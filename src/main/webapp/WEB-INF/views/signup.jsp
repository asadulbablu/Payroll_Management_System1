<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title> Sign up Page </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="resources/dashboardplug/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="resources/dashboardplug/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->
<script src="resources/dashboardplug/js/jquery-2.1.1.min.js"></script> 
<!--icons-css-->
<link href="resources/dashboardplug/css/font-awesome.css" rel="stylesheet">
<!--Google Fonts-->
<link href='resources/dashboardplug/fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
<link href='resources/dashboardplug/fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
<!--//charts-->
</head>
<body>	
<!--inner block start here-->
<div class="signup-page-main">
     <div class="signup-main">  	
    	 <div class="signup-head">
				<h1>Sign Up</h1>
			</div>
			<div class="signup-block">
				<form modelAttribute="urm" action="reguser" method="post">
					<input type="text" name="username" placeholder="Name" required="true">
					<input type="text" name="emailid" placeholder="Email" required="true">
					<input type="password" name="password" class="lock" placeholder="Password" required="true">
                                        <input type="text" name="phone" class="lock" placeholder="phone" required="true">
					<div class="forgot-top-grids">
						<div class="forgot-grid">
							<ul>
								<li>
									<input type="checkbox" id="brand1" value="">
									<label for="brand1"><span></span>I agree to the terms</label>
								</li>
							</ul>
						</div>
						
						<div class="clearfix"> </div>
					</div>
					<input type="submit" name="Sign In" value="Sign up">														
				</form>
				<div class="sign-down">
				<h4>Already have an account? <a href="login.jsp"> Login here.</a></h4>
				  <h5><a href="login">Go Back to Home</a></h5>
				</div>
			</div>
    </div>
</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2016 Shoppy. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
</div>	
<!--COPY rights end here-->
<!--scrolling js-->
		<script src="resources/dashboardplug/js/jquery.nicescroll.js"></script>
		<script src="resources/dashboardplug/js/scripts.js"></script>
		<!--//scrolling js-->
<script src="resources/dashboardplug/js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>


                      
						
