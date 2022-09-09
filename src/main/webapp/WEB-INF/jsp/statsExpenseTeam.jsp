<%-- 
    Document   : statsExpenseTeam
    Created on : Sep 2, 2022, 6:19:34 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;">THỐNG KÊ KHOẢN CHI THEO NGƯỜI DÙNG</h1>
<div class="col-2">
    <a href="<c:url value="/user/statsIncomeTeam"/>"><button type="button" class="btn btn-primary">Thống kê thu</button></a>
</div>
<div class="col-1">
    <a href="<c:url value="/user/list"/>"><button class="btn btn-warning">Back</button></a>
</div>

<div>
    <canvas id="myExpenseTeamChart"></canvas>
</div>

<form action="">
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control">
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control">
    </div>
    <input type="submit" value="Thống kê" class="btn btn-success">
</form>
<h2> Số liệu khoản chi theo người</h2>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Tên khoản chi</th>
        <th>Lần chi gần nhất</th>
        <th>Ngày chi</th>
        <th>Người chi</th>
        <th>Tổng số tiền đã chi</th>
    </tr>
    <c:forEach items="${statsExpenseTeam}" var="s">
        <tr>
            <td>${s[0]}</td>
            <td>${s[1]}</td>
            <td>${s[2]} VNĐ</td>
            <td>${s[3]}</td>
            <td>${s[4]}</td>
            <td>${s[5]} VNĐ</td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/resources/js/stats3.js"/>"></script>
<script>
    let expenseTeamLabels = [], expenseTeamInfo = []
    <c:forEach items="${statsExpenseTeam}" var="s">
    expenseTeamLabels.push('${s[4]}')
    expenseTeamInfo.push(${s[5]})
    </c:forEach>
    window.onload = function () {
        expenseChart("myExpenseTeamChart", expenseTeamLabels, expenseTeamInfo)
    }
</script>