<%-- 
    Document   : editExpense.jsp
    Created on : Aug 15, 2022, 6:25:20 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-4 pt-4">EDIT USER</h1>
<c:url value="updateUser" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="user">
    <form:hidden path="id" />
    <form:hidden path="password" />
    <form:hidden path="userRole" />

    <div class="mb-3 mt-3">
        <label for="firstName" class="form-label">FirstName</label>
        <form:input class="form-control" path="firstName" placeholder="Enter name" id="firstName" />
    </div>
    <div class="mb-3">
        <label for="lastName" class="form-label">LastName</label>
        <form:input class="form-control" path="lastName" placeholder="Last name" id="lastName"/>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <form:input class="form-control" path="email" placeholder="Email" id="email"/>
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <form:input class="form-control" path="phone" placeholder="Phone" id="phone"/>
    </div>
    <div class="mb-3">
        <label for="username" class="form-label">UserName</label>
        <form:input class="form-control" path="username" placeholder="Username" id="username"/>
    </div>
    <div class="mb-3">
        <label for="active" class="form-label">Active</label>
        <form:input class="form-control" path="active" placeholder="True or False" id="active"/>
    </div>


    <div class="form-floating row pt-4 pb-4">
        <br>
        <div class="col-1">
            <input type="submit" value="Edit" class="btn btn-primary" />
        </div>
    </div>

</form:form>
<div class="col-1">
    <a href="<c:url value="/admin/list"/>"><button class="btn btn-warning">Back</button></a>
</div>