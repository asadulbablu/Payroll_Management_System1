<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Deduction Page</title>
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
<!--static chart-->
<script src="resources/dashboardplug/js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
    <script src="dashboardplug/cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')</script>
    <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
     <!-- Chartinator  -->
    <script src="js/chartinator.js" ></script>
    <script src="resources/js/angular.js"></script>
    <script>
            var cat = ${deductionmodelobject};
            console.log(cat);
            angular.module('myapp', []).controller('CategoryController',
                    function ($scope) {
                        $scope.Catagory = cat;
                    });
        </script>
    <script type="text/javascript">
        jQuery(function ($) {

            var chart3 = $('#geoChart').chartinator({
                tableSel: '.geoChart',

                columns: [{role: 'tooltip', type: 'string'}],
         
                colIndexes: [2],
             
                rows: [
                    ['China - 2015'],
                    ['Colombia - 2015'],
                    ['France - 2015'],
                    ['Italy - 2015'],
                    ['Japan - 2015'],
                    ['Kazakhstan - 2015'],
                    ['Mexico - 2015'],
                    ['Poland - 2015'],
                    ['Russia - 2015'],
                    ['Spain - 2015'],
                    ['Tanzania - 2015'],
                    ['Turkey - 2015']],
              
                ignoreCol: [2],
              
                chartType: 'GeoChart',
              
                chartAspectRatio: 1.5,
             
                chartZoom: 1.75,
             
                chartOffset: [-12,0],
             
                chartOptions: {
                  
                    width: null,
                 
                    backgroundColor: '#fff',
                 
                    datalessRegionColor: '#F5F5F5',
               
                    region: 'world',
                  
                    resolution: 'countries',
                 
                    legend: 'none',

                    colorAxis: {
                       
                        colors: ['#679CCA', '#337AB7']
                    },
                    tooltip: {
                     
                        trigger: 'focus',

                        isHtml: true
                    }
                }

               
            });                       
        });
    </script>
<!--geo chart-->

<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>	
<div class="page-container">	
   <div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
				<div class="header-main">
					<div class="header-left">
							<div class="logo-name">
									 <a href="index.html"> <h1>Payroll</h1> 
									<!--<img id="logo" src="" alt="Logo"/>--> 
								  </a> 								
							</div>
							<!--search-box-->
								<div class="search-box">
									<form>
										<input type="text" placeholder="Search..." required="">	
										<input type="submit" value="">					
									</form>
								</div><!--//end-search-box-->
							<div class="clearfix"> </div>
						 </div>
						 <div class="header-right">
							<div class="profile_details_left"><!--notifications of menu start -->
								<ul class="nofitications-dropdown">
									<li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 3 new messages</h3>
												</div>
											</li>
											<li><a href="#">
											   <div class="user_img"><img src="images/p4.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											</a></li>
											<li class="odd"><a href="#">
												<div class="user_img"><img src="images/p2.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor </p>
												<p><span>1 hour ago</span></p>
												</div>
											  <div class="clearfix"></div>	
											</a></li>
											<li><a href="#">
											   <div class="user_img"><img src="images/p3.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											</a></li>
											<li>
												<div class="notification_bottom">
													<a href="#">See all messages</a>
												</div> 
											</li>
										</ul>
									</li>
									<li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 3 new notification</h3>
												</div>
											</li>
											<li><a href="#">
												<div class="user_img"><img src="images/p5.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor</p>
												<p><span>1 hour ago</span></p>
												</div>
											  <div class="clearfix"></div>	
											 </a></li>
											 <li class="odd"><a href="#">
												<div class="user_img"><img src="images/p6.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											 </a></li>
											 <li><a href="#">
												<div class="user_img"><img src="images/p7.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											 </a></li>
											 <li>
												<div class="notification_bottom">
													<a href="#">See all notifications</a>
												</div> 
											</li>
										</ul>
									</li>	
									<li class="dropdown head-dpdn">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">9</span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 8 pending task</h3>
												</div>
											</li>
											<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Database update</span><span class="percentage">40%</span>
													<div class="clearfix"></div>	
												</div>
												<div class="progress progress-striped active">
													<div class="bar yellow" style="width:40%;"></div>
												</div>
											</a></li>
											<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
												   <div class="clearfix"></div>	
												</div>
												<div class="progress progress-striped active">
													 <div class="bar green" style="width:90%;"></div>
												</div>
											</a></li>
											<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Mobile App</span><span class="percentage">33%</span>
													<div class="clearfix"></div>	
												</div>
											   <div class="progress progress-striped active">
													 <div class="bar red" style="width: 33%;"></div>
												</div>
											</a></li>
											<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
												   <div class="clearfix"></div>	
												</div>
												<div class="progress progress-striped active">
													 <div class="bar  blue" style="width: 80%;"></div>
												</div>
											</a></li>
											<li>
												<div class="notification_bottom">
													<a href="#">See all pending tasks</a>
												</div> 
											</li>
										</ul>
									</li>	
								</ul>
								<div class="clearfix"> </div>
							</div>
							<!--notification menu end -->
							<div class="profile_details">		
								<ul>
									<li class="dropdown profile_details_drop">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<div class="profile_img">	
<!--												<span class="prfil-img"><img src="images/p1.png" alt=""> </span> 
												<div class="user-name">
													<p>Malorum</p>
													<span>Administrator</span>
												</div>-->
												<i class="fa fa-angle-down lnr"></i>
												<i class="fa fa-angle-up lnr"></i>
												<div class="clearfix"></div>	
											</div>	
										</a>
										<ul class="dropdown-menu drp-mnu">
											<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
<!--											<li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> -->
											<li> <a href="login"><i class="fa fa-sign-out"></i> Logout</a> </li>
										</ul>
									</li>
								</ul>
							</div>
							<div class="clearfix"> </div>				
						</div>
				     <div class="clearfix"> </div>	
				</div>
<!--heder end here-->
<!-- script-for sticky-nav -->

		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
                
<!--inner block start here-->
<jsp:include page="header.jsp" />
<div class="inner-block">
<!--market updates updates-->
	 <div class="market-updates">
			<div class="formcontainer">
                            <div class="pagetitle" align="center"><h4>Add Deduction</h4></div>
                       <c:if test="${check}">
                            <form:form name="adddeductionbject"
                                       modelAttribute="adddeductionbject1" action="addingdeduction"
                                       method="post">
                                <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="Deduction Id" type="text" path="deductionid" required="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input class="form-control"
                                                Placeholder="Deduction Head" type="text" path="deductionhead" required="true"></form:input>
                                    </div>
                                    
                                <form:button id="editbuttons" type="submit" name="Adddeduction"
                                             class="btn btn-success">Add Deduction</form:button>
                                <form:button id="removebuttons" type="reset" class="btn btn-primary">Reset
                                    Details</form:button>

                            </form:form>
                        </c:if>

                        <c:if test="${!check}">
                            <form:form name="adddeductionbject"
                                       modelAttribute="adddeductionbject1" action="addingdeduction"
                                       method="post">
                                <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="Deduction Id" type="text" path="deductionid" readonly="true"></form:input>
                                    </div>
                                    <div class="form-group">
                                    <form:input id="name" class="form-control"
                                                Placeholder="Deduction Head" type="text" path="deductionhead"></form:input>
                                    </div>
                                    
                                <form:button id="editbuttons" type="submit" name="Editdeduction"
                                             class="btn btn-success">Edit Deduction</form:button>
                                <form:button id="removebuttons" type="reset" class="btn btn-info">Reset
                                    Details</form:button>
                            </form:form>
                        </c:if>
                    </div>
		</div>
<!--market updates end here-->
<div class="chit-chat-layer1">
	<div class="card-body" >
            <div class="green">
                    <span class="lead">List Of Deduction</span>
                </div>
                                <div class="table-responsive"  ng-app="myapp"
                     ng-controller="CategoryController" width="100%">
                                   <p><input type="text" ng-model="test" class="form-control" placeholder="Search deduction"></p>
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Deduction Id</th>
                                                <th>Deduction Head</th>
                                                
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <tr ng-repeat="deduct in Catagory | filter:test">
                                               
                                                <td>{{deduct.deductionid}}</td>
                                                <td>{{deduct.deductionhead}}</td>
                                                <td><a href="editdeductionbutton?getcid={{deduct.deductionid}}"><button id="editbuttons" type="submit" class="btn btn-warning">Edit</button></a> 
                                                    <a href="removededuction/{{deduct.deductionid}}"><button id="removebuttons" type="button" class="btn btn-danger">Remove</button></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
</div>


</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2018 Payroll Management System. All Rights Reserved  </p>
</div>	
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
    <div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href="index.html"><i class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
		        
                   <li><a href="#"><i class="fa fa-cogs"></i><span>Reports</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul>
		           <li id="menu-academico-avaliacoes" ><a href="reportView">Net Salary_Report</a></li>
                             <li id="menu-academico-avaliacoes" ><a href="reportView3">Net Monthly Salary_Report</a></li>
                             <li id="menu-academico-avaliacoes" ><a href="reportView2">Employee Info Report</a></li>
                              <li id="menu-academico-avaliacoes" ><a href="reportView4">Employee Loan Report</a></li>
                              <li id="menu-academico-avaliacoes" ><a href="reportView5">Employee Payment History</a></li>
		          </ul>
		        </li>
		        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text"></i><span>Pages</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
                            <li id="menu-academico-boletim" ><a href="showingdepartmentpage">Add Department</a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showingjobtypepage">Add Job Type</a></li>	
                            <li id="menu-academico-boletim" ><a href="showingbasicyearpage">Add Basic Year</a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showjobtitlepage">Add Job Title</a></li>
                            <li id="menu-academico-boletim" ><a href="showempinfopage">Add Employee </a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showingallowancepage">Add Allowance</a></li>	
                            <li id="menu-academico-boletim" ><a href="showingdeductionpage">Add Deduction</a></li>
		            </ul>
		        </li>
                        
                        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text"></i><span> Another Pages</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
                            <li id="menu-academico-avaliacoes" ><a href="showingloanpage">Add Loan Type</a></li>
                            <li id="menu-academico-boletim" ><a href="showemploanpage">Add Emp Loan</a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showloanpaypage">Add Loan Payment</a></li>
<!--                            <li id="menu-academico-boletim" ><a href="paymentallowancepage">Add Payment Allowance </a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showpaydeductpage">Add Payment Deduction</a></li>	-->
                            <li id="menu-academico-boletim" ><a href="showpayallowcalpage">Cal Allowance Per Month</a></li>
		            <li id="menu-academico-avaliacoes" ><a href="showpaydeductcalpage">Cal Deduction Per Month</a></li>
                            <li id="menu-academico-avaliacoes" ><a href="showingpaymenttypepage">Add Payment Type</a></li>
                            <li id="menu-academico-avaliacoes" ><a href="showpaymentpage">Add Payment </a></li>
                            <li id="menu-academico-avaliacoes" ><a href="shownetsalarypage">Net Salary </a></li>
		          </ul>
		        </li>
		        
		        <li><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span></a></li>
		        <li><a href="#"><i class="fa fa-envelope"></i><span>Mailbox</span><span class="fa fa-angle-right" style="float: right"></span></a>
		        	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="inbox.html">Inbox</a></li>
			            <li id="menu-academico-boletim" ><a href="inbox-details.html">Compose email</a></li>
		             </ul>
		        </li>
		         <li><a href="#"><i class="fa fa-cog"></i><span>System</span><span class="fa fa-angle-right" style="float: right"></span></a>
		         	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="404.html">404</a></li>
			            <li id="menu-academico-boletim" ><a href="blank.html">Blank</a></li>
		             </ul>
		         </li>
		         <li><a href="#"><i class="fa fa-shopping-cart"></i><span>E-Commerce</span><span class="fa fa-angle-right" style="float: right"></span></a>
		         	<ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="product.html">Product</a></li>
			            <li id="menu-academico-boletim" ><a href="price.html">Price</a></li>
		             </ul>
		         </li>
		      </ul>
		    </div>
	 </div>
	<div class="clearfix"> </div>
</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<script src="resources/dashboardplug/js/jquery.nicescroll.js"></script>
		<script src="jresources/dashboardplug/s/scripts.js"></script>
		<!--//scrolling js-->
<script src="resources/dashboardplug/js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>                     