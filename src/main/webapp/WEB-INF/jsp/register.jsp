<%-- 
    Document   : register
    Created on : Aug 11, 2022, 10:20:00 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Register of </title>
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/register.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="cardH card-5">
                    <div class="card-heading">
                        <h2 class="title">Event Registration Form</h2>
                    </div>
                    <c:if test="${errMsg != null}">
                        <div class="alert alert-danger">
                            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                            ${errMsg}
                        </div>
                    </c:if>
                    <div class="card-body"> 
                        <form:form method="POST" 
                                   modelAttribute="user" 
                                   enctype="multipart/form-data">
                            <div class="form-row m-b-55">
                                <div class="name">Name</div>
                                <div class="value">
                                    <div class="row row-space">
                                        <div class="col-6">
                                            <div class="input-group-desc">
                                                <form:input class="input--style-5" path="firstName" id="firstName" placeholder="Enter first name"/>
                                                <label class="label--desc">first name</label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group-desc">
                                                <form:input class="input--style-5" path="lastName" type="text" id="lastName" placeholder="Enter last name"/>
                                                <label class="label--desc">last name</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Email</div>
                                <div class="value">
                                    <div class="input-group">
                                        <form:input class="input--style-5" path="email"  name="email" placeholder="Enter email"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Phone</div>
                                <div class="value">
                                    <div class="input-group">
                                        <form:input class="input--style-5" path="phone" type="text" name="phone" placeholder="Enter phone"/>
                                    </div>
                                </div>
                            </div>
                            

                            <div class="form-row">
                                <div class="name">UserName</div>
                                <div class="value">
                                    <div class="input-group">
                                        <form:input class="input--style-5" path="username" type="text" id="username" placeholder="Enter username"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Password</div>
                                <div class="value">
                                    <div class="input-group">
                                        <form:input class="input--style-5" path="password" type="password" id="password" placeholder="Enter password"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Confirm Password</div>
                                <div class="value">
                                    <div class="input-group">
                                        <form:input class="input--style-5" path="confirmPassword" type="password" id="confirm-password" placeholder="Enter comfirm password"/>
                                    </div>
                                </div>
                            </div>                           
                            <div class="form-row">
                                <div class="name">Avatar</div>
                                <div class="value">
                                    <div class="input-group" style="border: 1px solid grey">
                                        <form:input class="input--style-4" path="file" type="file" id="file"/>
                                    </div>
                                </div>
                            </div>
                            <div style="text-align: center;">
                                <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>