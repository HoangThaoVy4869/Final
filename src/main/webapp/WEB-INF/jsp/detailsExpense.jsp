<%-- 
    Document   : detailsExpense
    Created on : Aug 16, 2022, 4:53:36 PM
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
        <p>Danh mục: </p>
        <p>Ngày chi: </p>
        <p>Nội dung ghi chú: </p>
    </div>
    <div class="col-md-7">
        <p class="col-2">${expense.name}</p>
        <p class="col-3">${expense.amount}</p>
        <p class="col-2">${expense.categoryId.name}</p>
        <p class="col-2">${expense.date}</p>
        <p class="col-2">${expense.note}</p>
    </div>
</div>

<div>
    <a href="<c:url value="/home"/>"><button class="btn btn-warning">Back</button></a>
</div>