<%-- 
    Document   : statsIncome
    Created on : Aug 21, 2022, 4:10:10 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;">THỐNG KÊ KHOẢN THU THEO THỜI GIAN</h1>

<div>
  <canvas id="myIncomeChart"></canvas>
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

<table class="table">
    <tr>
        <th>Id</th>
        <th>Tên khoản thu nhập</th>
        <th>Số tiền</th>
        <th>Ngày thu nhập</th>
    </tr>
    <c:forEach items="${statsIncome}" var="s">
        <tr>
            <td>${s[0]}</td>
            <td>${s[1]}</td>
            <td>${s[2]} VNĐ</td>
            <td>${s[3]}</td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/resources/js/stats2.js"/>"></script>
<script>
    let incomeLabels=[], incomeInfo=[]
    <c:forEach items="${statsIncome}" var="s">
        incomeLabels.push('${s[3]}')
        incomeInfo.push(${s[2]})
    </c:forEach>
    window.onload = function() {
        incomeChart("myIncomeChart",incomeLabels, incomeInfo)
    }
</script>
