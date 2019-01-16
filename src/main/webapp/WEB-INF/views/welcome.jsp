<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Welcome Page</title>
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
        <script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')</script>
        <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
        <!-- Chartinator  -->
        <script src="js/chartinator.js" ></script>
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

                    chartOffset: [-12, 0],

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
            $(document).ready(function () {
                var navoffeset = $(".header-main").offset().top;
                $(window).scroll(function () {
                    var scrollpos = $(window).scrollTop();
                    if (scrollpos >= navoffeset) {
                        $(".header-main").addClass("fixed");
                    } else {
                        $(".header-main").removeClass("fixed");
                    }
                });

            });
                    </script>
                    <!-- /script-for sticky-nav -->
                    <!--inner block start here-->
                    <div class="inner-block">
                        <!--market updates updates-->
                        <div class="market-updates">
                            <div class="col-md-4 market-update-gd">
                                <div class="market-update-block clr-block-1">
                                    <div class="col-md-8 market-update-left">
                                        <h3>10</h3>
                                        <h4>Admin</h4>
                                        <p>Other hand, we denounce</p>
                                    </div>
                                    <div class="col-md-4 market-update-right">
                                        <i class="fa fa-file-text-o"> </i>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <div class="col-md-4 market-update-gd">
                                <div class="market-update-block clr-block-2">
                                    <div class="col-md-8 market-update-left">
                                        <h3>08</h3>
                                        <h4>Sales</h4>
                                        <p>Other hand, we denounce</p>
                                    </div>
                                    <div class="col-md-4 market-update-right">
                                        <i class="fa fa-file-text-o"> </i>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <div class="col-md-4 market-update-gd">
                                <div class="market-update-block clr-block-3">
                                    <div class="col-md-8 market-update-left">
                                        <h3>05</h3>
                                        <h4>HR</h4>
                                        <p>Other hand, we denounce</p>
                                    </div>
                                    <div class="col-md-4 market-update-right">
                                        <i class="fa fa-file-text-o"> </i>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <!--market updates end here-->
                        <!--mainpage chit-chating-->
                        <div class="chit-chat-layer1">
                            <div class="col-md-6 chit-chat-layer1-left">
                                <div class="work-progres">
                                    <div class="chit-chat-heading">
                                        Recent Employers
                                    </div>
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>S.N</th>
                                                    <th>Name</th>
                                                    <th>Department</th>                                   

                                                    <th>Status</th>
                                                    <th>Progress</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Khaled Hasan</td>
                                                    <td>Admin</td>                                 

                                                    <td><span class="label label-danger">in progress</span></td>
                                                    <td><span class="badge badge-info">50%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Mossarof Hossain</td>
                                                    <td>Admin</td>                               

                                                    <td><span class="label label-success">completed</span></td>
                                                    <td><span class="badge badge-success">100%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Shahed Alom</td>
                                                    <td>Admin</td>                                

                                                    <td><span class="label label-warning">in progress</span></td>
                                                    <td><span class="badge badge-warning">75%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Rakibul Islam</td>
                                                    <td>Sales </td>                                 

                                                    <td><span class="label label-info">in progress</span></td>
                                                    <td><span class="badge badge-info">65%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Awlad Hossain</td>
                                                    <td>HR</td>                                

                                                    <td><span class="label label-warning">in progress</span></td>
                                                    <td><span class="badge badge-danger">95%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>6</td>
                                                    <td>Saidul Alom</td>
                                                    <td>HR</td>                                  

                                                    <td><span class="label label-info">in progress</span></td>
                                                    <td><span class="badge badge-success">95%</span></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 chit-chat-layer1-left">
                                <div class="work-progres">
                                    <div class="chit-chat-heading">
                                        Allowance Deduction Rate Year-2018
                                    </div>
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>S.N</th>
                                                    <th>Allowance</th>
                                                    <th>Rate</th>
                                                    <th>Deduction</th>                                   

                                                    <th>Rate</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>House Rent</td>
                                                    <td><span class="badge badge-info">10%</span></td>                                

                                                    <td>Provident Fund</td>
                                                    <td><span class="badge badge-info">10%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Treatment</td>
                                                    <td><span class="badge badge-info">5%</span></td>                                

                                                    <td>welfare fund</td>
                                                    <td><span class="badge badge-info">5%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Festival</td>
                                                    <td><span class="badge badge-info">5%</span></td>                                

                                                    <<td>Special Fund</td>
                                                    <td><span class="badge badge-info">5%</span></td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Transeport</td>
                                                    <td><span class="badge badge-info">5%</span></td>                                

                                                    <td>Others Fund</td>
                                                    <td><span class="badge badge-info">10%</span></td>
                                                </tr>

                                                <tr>
                                                    <td>6</td>
                                                    <td>Education</td>
                                                    <td><span class="badge badge-info">5%</span></td>                                


                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>

                    </div>
                    <!--inner block end here-->
                    <!--copy rights start here-->
                    <div class="copyrights">
                        <p>� 2018 Payroll Management System. All Rights Reserved  </p>
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
                        <li id="menu-home" ><a href="welcome"><i class="fa fa-tachometer"></i><span>Dashboard</span></a></li>

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

            $(".sidebar-icon").click(function () {
                if (toggle)
                {
                    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
                    $("#menu span").css({"position": "absolute"});
                } else
                {
                    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
                    setTimeout(function () {
                        $("#menu span").css({"position": "relative"});
                    }, 400);
                }
                toggle = !toggle;
            });
        </script>
        <!--scrolling js-->
        <script src="resources/dashboardplug/js/jquery.nicescroll.js"></script>
        <script src="jresources/dashboardplug/s/scripts.js"></script>
        <!--//scrolling js-->
        <script src="resources/dashboardplug/js/bootstrap.js"></script>
        <!-- mother grid end here-->
    </body>
</html>                     