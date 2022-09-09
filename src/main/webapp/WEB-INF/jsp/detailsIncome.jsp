<%-- 
    Document   : detailsIncome
    Created on : Aug 21, 2022, 4:09:40 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">CHI TIẾT KHOẢN CHI</h1>

<div class="row">
    <div class="col-md-5">
        <p>Tên khoản thu nhập: </p>
        <p>Số tiền: </p>
        <p>Danh mục: </p>
        <p>Ngày thu: </p>
        <p>Nội dung ghi chú: </p>
    </div>
    <div class="col-md-7">
        <p class="col-2">${income.name}</p>
        <p class="col-3">${income.amount}</p>
        <p class="col-2">${income.categoryId.name2}</p>
        <p class="col-2">${income.date}</p>
        <p class="col-2">${income.note}</p>
    </div>
</div>

<div>
    <a href="<c:url value="/user/incomeList"/>"><button class="btn btn-warning">Back</button></a>
</div>