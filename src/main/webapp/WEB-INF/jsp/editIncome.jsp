<%-- 
    Document   : editIncome
    Created on : Aug 21, 2022, 4:09:22 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-4 pt-4">EDIT INCOME</h1>
<c:url value="updateIncome" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="income">
    <form:hidden path="id"/>
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Name</label>
        <form:input class="form-control" path="name" placeholder="Enter name" id="name" />
        <form:errors path="name" element="div" cssClass="text-danger" />
    </div>
    <div class="mb-3">
        <label for="amount" class="form-label">Amount</label>
        <form:input class="form-control" path="amount" placeholder="Enter price...$" id="amount" type="number" />
        <form:errors path="amount" element="div" cssClass="text-danger" />
    </div>

    <div class="form-group row">
        <div class="col">
            <label for="cate" class="form-label">Category</label>
            <form:select id="cate" path="categoryId" class="form-select">
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name2}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="col">
            <label for="startDate" class="form-label">Date</label>
            <form:input path="date" id="date" class="form-control" type="date"/>
            <form:errors path="date" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="mt-3">
        <label for="note" class="form-label">Note</label>
        <form:textarea path="note" class="form-control" rows="5" id="note" name="text"></form:textarea>
        </div>

        <div class="form-floating row pt-4 pb-4">
            <br>
            <div class="col-1">
                <input type="submit" value="Edit" class="btn btn-primary" />
            </div>
        </div>
</form:form>

<div class="col-1">
    <a href="<c:url value="/user/incomeList"/>"><button class="btn btn-warning">Back</button></a>
</div>
