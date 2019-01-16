<%-- 
    Document   : addproduct
    Created on : Nov 25, 2018, 5:18:28 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">

            .panel>.panel-heading {
                color: #558b2f;
                background-color: #aed581;
                border-color: #aed581;
            }
            .panel>.panel-body
            {
                background-color: #f1f8e9;
                border-color: #aed581;
            }

            .form-control:FOCUS
            {
                border: 2px thin #9ccc65;
                border-radius: 5px;
            }
            .list-group-item {
                overflow: hidden;
            }
            #removebuttons
            {
                color: #ffffff;
                background-color: #e57373;
            }
            #removebuttons:HOVER {
                color: #ffffff;
                background-color: #e53935;
            }
            #editbuttons{
                color: #ffffff;
                background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);	
            }
            #editbuttons:HOVER {
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);	
            }
        </style>
        <script src="resources/js/angular.js"></script>

        <script>
            var emplist = ${empinfolist};
            var deptlist = ${departmentlist};
            var typelist=   ${jobtypemodelobject};
            var titlelist=   ${jobtitlemodelobject};
            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.empl= emplist;
                        $scope.deptl = deptlist;
                        $scope.tpl = typelist;
                        $scope.tll = titlelist;
                        console.log($scope.tpl);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Managing Employee Info </span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newempinfoObject" action="empinfoadd"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="Employee Id"
                                                type="text" path="empid" required="true"></form:input>
                                    </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="Employee Id"
                                                type="text" path="empid" readonly="true" required="true"></form:input>
                                    </div>
                            </c:if>
                            
                                <div class="form-group">
                                <form:input class="form-control" Placeholder="Employee Name"
                                            type="text" path="empname" required="true"></form:input>
                                </div>
                               <div class="form-group">
                                    <label>Sex</label>
                                    <label class="radio-inline">
                                <form:radiobutton path="gender" value="Male"/>Male </label>
                                <label class="radio-inline">
                                <form:radiobutton path="gender" value="Female"/>Female </label>
                                </div>
                               <div class="form-group">
                                <form:input type="text" class="form-control"
                                            Placeholder="Joining Date" path="joiningdate" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"
                                            placeholder="phoneno" path="phoneno" required="true"></form:input>
                                </div>
                            <div class="form-group">
                         <select class="form-control" ng-model="typeid" ng-options="x.typeid as x.typename for x in tpl" >
                                    <option value="">-- choose an option --</option>
                                </select>
                             </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{typeid}}" path="typeid"></form:hidden>
                            </div>
                            <div class="form-group">
                         <select class="form-control" ng-model="deptid" ng-options="x.deptid as x.deptname for x in deptl" >
                                    <option value="">-- choose an option --</option>
                                </select>
                             </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{deptid}}" path="deptid"></form:hidden>
                            </div>
                            <div class="form-group">
                         <select class="form-control" ng-model="select" ng-options="x.basicsalary for x in tll" >
                                    <option value="">-- choose an option --</option>
                                </select>
                             </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{select.jobtitleid}}" path="jobtitleid"></form:hidden>
                            </div>
                            <div class="form-group">
                                <form:input type="file" name="fileToUpload" id="fileToUpload"
                                            path="empimage" required="true"></form:input>
                                </div>
                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="Add" class="btn">Add
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            <c:if test="${!check}">
                                <form:button id="editbuttons" type="submit" name="Edit" class="btn">Edit
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                        </form:form>
                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">Employee Lists</span>
                </div>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="emp in empl">
                            <table style="width: 100%">
                                <tr>
                                    <td><img style="width:125px ;height:150px" src="resources/pimage/{{emp.empid}}.jpg" />
                                    </td>
                                    <td>
                                        <ul>
                                            <li><span><b>Employee Id: </b></span>{{emp.empid}}</li>
                                            <li><span><b>Employee Name: </b></span>{{emp.empname}}</li>
                                            <li><span><b>Gender: </b></span>{{emp.gender}}</li>
                                            <li><span><b>Phone: </b></span>{{emp.phoneno}}</li>
                                            <li><span><b>Type Id: </b></span>{{emp.typeid}}</li>
                                            <li><span><b>Department Id: </b></span>{{emp.deptid}}</li>
                                            <li><span><b>Job Title Id: </b></span>{{emp.jobtitleid}}</li>
                                        </ul>
                                    </td>
                                    <td><a href="editempinfo?getpid={{emp.empid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingempinfo/{{emp.empid}}"><button id="removebuttons"
                                                                                             type="button" class="btn">Remove</button></a></td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </div>
                <!-- panel2 body end -->
            </div>
            <!-- panel2 end -->
        </div>

        <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="joiningdate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>

    </body>
</html>
