<%-- 
    Document   : index
    Created on : Aug 12, 2022, 4:53:27 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container pt-4 mt-3">
        <h2>Quản lý người dùng</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>UserName</th>
                    <th>Active</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${user}" var="u" varStatus="loop">
                    <tr>
                        <td class="col-1">${loop.count}</td>
                        <td class="col-2">${u.firstName}</td>
                        <td class="col-2">${u.lastName}</td>
                        <td class="col-2">${u.email}</td>
                        <td class="col-2">${u.phone}</td>
                        <td class="col-2">${u.username}</td>
                        <td class="col-2">${u.active}</td>                       
                        <td class="col-12" style="display: flex; ">  
                            <a style="margin-right: 5px" href="<c:url value="/admin/editUser/${u.id}"/>"><button class="btn btn-warning">Edit</button></a>
                            <a  href="<c:url value="/admin/deleteUser/${u.id}"/>"><button class="btn btn-danger">Delete</button></a>
                            
                                     
                        </td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>
    </div>
</body>
