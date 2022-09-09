<%-- 
    Document   : detailsdetailsTeam
    Created on : Sep 1, 2022, 11:44:20 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">CHI TIẾT KHOẢN CHI</h1>

<div class="row">
    <div class="col-md-5">
        <p>Tên khoản chi: </p>
        <p>Số tiền: </p>
        <p>Nội dung chi: </p>
        <p>Ngày chi: </p>
        <p>Người chi: </p>
    </div>
    <div class="col-md-7">
        <p class="col-2">${details.name}</p>
        <p class="col-3">${details.expense}</p>
        <p class="col-2">${details.description}</p>
        <p class="col-2">${details.date}</p>
        <p class="col-2">${details.userId.username}</p>
    </div>
</div>

<div>
    <a href="<c:url value="/user/expenseTeamList"/>"><button class="btn btn-warning">Back</button></a>
</div>
