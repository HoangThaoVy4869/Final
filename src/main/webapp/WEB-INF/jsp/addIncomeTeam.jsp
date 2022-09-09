<%-- 
    Document   : addIncomeTeam
    Created on : Sep 2, 2022, 4:04:58 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-4 pt-4">ADD NEW INCOME TEAM</h1>

<c:url value="/user/addIncomeTeam" var="action"/>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
    
<form:form method="post" action="${action}" modelAttribute="Incomedetails">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Income Name</label>
        <form:input class="form-control" path="name" placeholder="Enter name" id="name" />
        
    </div>
    <div class="mb-3">
        <label for="income" class="form-label">Amount</label>
        <form:input class="form-control" path="income" placeholder="Enter price...$" id="income" type="number" />
        
    </div>

    <div class="form-group row">
        <div class="col">
            <label for="date" class="form-label">Date</label>
            <form:input path="date" id="date" class="form-control" type="date"/>
            
        </div>
    </div>

    <div class="mt-3">
        <label for="note" class="form-label">Description</label>
        <form:textarea path="description" class="form-control" rows="5" id="description" name="text"></form:textarea>
    </div>

    <div class="form-floating row pt-4 pb-4">
        <br>
        <div class="col-1">
            <input type="submit" value="Add news" class="btn btn-primary" />
        </div>
    </div>
</form:form>
<div class="col-1">
    <a href="<c:url value="/user/incomeTeamList"/>"><button class="btn btn-warning">Back</button></a>
</div>
