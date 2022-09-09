<%-- 
    Document   : home
    Created on : Sep 2, 2022, 2:01:30 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Manager</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/home.css"/>">
    </head>
    <body>
        <div class="content">
            <div class="login-home"><a href="<c:url value="/login"/>">Login</a></div>
            <div class="gach">/</div>
            <div class="register-home"><a href="<c:url value="/register"/>">Register</a></div>
        </div>

    </body>
</html>
