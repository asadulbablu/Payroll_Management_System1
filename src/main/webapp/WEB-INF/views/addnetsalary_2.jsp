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
            var nsalarylist = ${nsalarylist};
            var emplist = ${emplist};
            var jobtitlelist = ${jobtitlelist};
            var jacallist = ${jacallist};
            var jdcallist = ${jdcallist};
            

            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.nsal = nsalarylist;
                        $scope.emp = emplist;
                        $scope.jtitle = jobtitlelist;
                        $scope.jallow = jacallist;
                        $scope.jdeduct = jdcallist;

                        console.log($scope.job);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Managing Payment Allowance</span>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newnetsalaryObject" action="addingnetsalary"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="Net Salary Id"
                                                type="text" path="netsalaryid" required="true"></form:input>
                                    </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="Net Salary Id"
                                                type="text" path="netsalaryid" readonly="true" required="true"></form:input>
                                    </div>
                            </c:if>
                                                           
                            <div class="form-group">
                            <select class="form-control" ng-model="selectedSup" ng-options="x.empname for x in emp">
                                <option value="">-- choose an option --</option>
                            </select>
                                <div class="form-group">
                            <form:hidden  class="form-control" value="{{selectedSup.empid}}" path="empid"></form:hidden>
                            </div>
                             </div>
                            <div class="form-group">
                                <form:input type="text" class="form-control" value="{{selectedSup.empname}}" path="empname"></form:input>
                            </div>
                            
                            <div class="form-group">
                            <select class="form-control" ng-model="selectedSup1" ng-options="p.basicsalary for p in jtitle">
                                <option value="">-- choose an option --</option>
                            </select>
                             </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{selectedSup1.jobtitleid}}" path="jobtitleid"></form:hidden>
                            </div>
                        </div>
                            <div class="form-group">
                                <div class="form-group">
                                <form:input class="form-control" value="{{selectedSup1.basicsalary}}" path="basicsalary"></form:input>
                            </div>
                            <div class="form-group">
                            <select class="form-control" ng-model="selectedSup2" ng-options="ja.totalallowpermonth for ja in jallow">
                                <option value="">-- choose an option --</option>
                            </select>
                             </div>
                            
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{selectedSup2.joballowcalid}}" path="joballowcalid"></form:hidden>
                            </div>
                        </div>
                            <div class="form-group">
                                <div class="form-group">
                                <form:input class="form-control" value="{{selectedSup2.totalallowpermonth}}" path="totalallowpermonth"></form:input>
                            </div>
                                
                            </div>
                            <div class="form-group">
                            <select class="form-control" ng-model="selectedSup3" ng-options="ja.totaldeductpermonth for ja in jdeduct">
                                <option value="">-- choose an option --</option>
                            </select>
                             </div>
                            
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{selectedSup3.jobdeductcalid}}" path="jobdeductcalid"></form:hidden>
                            </div>
                        
                            <div class="form-group">
                                <div class="form-group">
                                <form:input class="form-control" value="{{selectedSup3.totaldeductpermonth}}" path="totaldeductpermonth"></form:input>
                            </div>
                                
                            </div>
                            </div>
                              <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="Add" class="btn ">Add
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
                    <span class="lead">Net Salary Lists</span>
                </div>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="p in nsal">
                            <table style="width: 100%">
                                <tr>
                                   <td>
                                        <ul>
                                            <li><span><b>Net Salary Id: </b></span>{{p.netsalaryid}}</li>
                                            <li><span><b>Employee Id: </b></span>{{p.empid}}</li>
                                            <li><span><b>Employee Name </b></span>{{p.empname}}</li>
                                            <li><span><b>Basic Salary </b></span>{{p.basicsalary}}</li>
                                            <li><span><b>Total Allowance </b></span>{{p.totalallowpermonth}}</li>
                                            <li><span><b>Total Deduction </b></span>{{p.totaldeductpermonth}}</li>
                                             <li><span><b>Net Salary </b></span>{{p.netsalary}}</li>                                          
                                        </ul>
                                    </td>
                                    <td><a href="editnetsalarypage?getpid={{p.netsalaryid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingnetsalary/{{p.netsalaryid}}"><button id="removebuttons"
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
    </body>
</html>
