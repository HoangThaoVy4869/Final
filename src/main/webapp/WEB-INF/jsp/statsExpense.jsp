<%-- 
    Document   : statsExpense
    Created on : Aug 16, 2022, 6:27:34 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center">THỐNG KÊ KHOẢN CHI THEO THỜI GIAN</h1>

<div>
  <canvas id="myExpenseChart"></canvas>
</div>

<form action="">
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control">
    </div>
    <div class="form-group" style="margin-bottom: 10px">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control">
    </div>
    <input type="submit" value="Thống kê" class="btn btn-success">
</form>
<br />

<a href="statsExpenseMonth"><button class="btn btn-warning">Thống kê theo tháng</button></a>

<table class="table">
    <tr>
        <th>STT</th>
        <th>Tên khoản chi</th>
        <th>Số tiền</th>
        <th>Ngày chi</th>
    </tr>
    <c:forEach items="${statsExpense}" var="s" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${s[1]}</td>
            <td>${s[2]} VNĐ</td>
            <td>${s[3]}</td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/resources/js/stats.js"/>"></script>
<script>
    let expenseLabels=[], expenseInfo=[]
    <c:forEach items="${statsExpense}" var="s">
        expenseLabels.push('${s[3]}')
        expenseInfo.push(${s[2]})
    </c:forEach>
    window.onload = function() {
        expenseChart("myExpenseChart",expenseLabels, expenseInfo)
    }
</script>