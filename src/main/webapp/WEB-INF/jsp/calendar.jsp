<%-- 
    Document   : calendar
    Created on : Sep 3, 2022, 12:37:05 AM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/resources/js/calendar.js"/>"></script>
<style>
    a{
        color: #000;
        text-decoration: none;
    }
    .fc .fc-toolbar.fc-header-toolbar {
        margin-top: 15px;
    }
</style>
<div class="col-1">
        <a href="<c:url value="/user/list"/>"><button class="btn btn-warning">Back</button></a>
</div>
<body>
    <div id='calendar'></div>
</body>
