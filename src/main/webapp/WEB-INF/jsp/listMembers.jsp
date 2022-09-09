<%-- 
    Document   : listMembers
    Created on : Aug 23, 2022, 4:38:32 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/resources/js/main.js"/>"></script>
<h1 class="text-center text-info">DANH SÁCH THÀNH VIÊN</h1>

<c:if test="${members == null}">
    <h3 class="text-center text-danger">Chưa có thành viên nào trong nhóm</h3>
</c:if>
    
<c:if test="${members != null}">
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Tên thành viên</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${members}" var="m">
        <tr>
            <td class="col-1">${m.userId}</td>
            <td class="col-3">${m.username}</td>
            <td class="col-3">${m.email}</td>
            <td class="col-2">
                <a onclick="deleteMembers(${m.userId})" ><button class="btn btn-danger">Xóa khỏi nhóm</button></a>
            </td>
        </tr>
        </c:forEach>      
    </table>
    <input type="submit" onclick="addUserTeam()" value="Thêm vào nhóm" class="btn btn-primary" />
    <div class="col-1">
        <a href="<c:url value="/user/list"/>"><button class="btn btn-warning">Back</button></a>
    </div>
</c:if>