<%-- 
    Document   : IncomedetailsIncomeTeam
    Created on : Sep 2, 2022, 4:08:47 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">CHI TIẾT KHOẢN THU</h1>

<div class="row">
    <div class="col-md-5">
        <p>Tên khoản thu: </p>
        <p>Số tiền: </p>
        <p>Nội dung thu: </p>
        <p>Ngày thu: </p>
        <p>Người thu: </p>
    </div>
    <div class="col-md-7">
        <p class="col-2">${Incomedetails.name}</p>
        <p class="col-3">${Incomedetails.income}</p>
        <p class="col-2">${Incomedetails.description}</p>
        <p class="col-2">${Incomedetails.date}</p>
        <p class="col-2">${Incomedetails.userId.username}</p>
    </div>
</div>

<div>
    <a href="<c:url value="/user/incomeTeamList"/>"><button class="btn btn-warning">Back</button></a>
</div>
