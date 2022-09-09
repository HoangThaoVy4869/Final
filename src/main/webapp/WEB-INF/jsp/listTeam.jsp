<%-- 
    Document   : listTeam
    Created on : Aug 20, 2022, 8:27:52 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container pt-4 mt-3">
    <h2>Danh sách Nhóm</h2>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên nhóm</th>
                <th>Mô tả</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${team}" var="t">
                <tr>
                    <td class="col-2">${t.id}</td>
                    <td class="col-3">${t.name}</td>
                    <td class="col-2">${t.description}</td>
                    <td class="col-2">
                        <a href="<c:url value="/user/list/${t.id}"/>"><button type="button" class="btn btn-primary">Thêm thành viên</button></a>                  
                    </td>
                </tr>
            </c:forEach>        
        </tbody>
    </table>
</div>
