<%-- 
    Document   : login
    Created on : Aug 9, 2022, 5:14:07 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">

    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <c:if test="${param.error != null}">
                        <div style="background-color: pink">Error!!!!</div>
                    </c:if>
                    <c:if test="${param.accessDenied != null}">
                        <div style="background-color: pink">
                            Ban khong co quyen truy cap!!!
                        </div>
                    </c:if>
                    <form:form class="login100-form validate-form" 
                               method="POST">
                        <span class="login100-form-title p-b-26">
                            Welcome
                        </span>
                        <span class="login100-form-title p-b-48">
                            <i class="zmdi zmdi-font"></i>
                        </span>

                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" id="username" name="username"/>
                            <span class="focus-input100" data-placeholder="UserName"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <span class="btn-show-pass">
                                <i class="zmdi zmdi-eye"></i>
                            </span>
                            <input class="input100" type="password" id="password" name="password"/>
                            <span class="focus-input100" data-placeholder="Password"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                        </div>

                        <div class="text-center p-t-115">
                            <span class="txt1">
                                Don’t have an account?
                            </span>

                            <a class="txt2" href="register">
                                Sign Up
                            </a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div id="dropDownSelect1"></div>      
    </body>
</html>
