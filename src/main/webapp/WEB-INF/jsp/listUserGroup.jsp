<%-- 
    Document   : addUserGroup
    Created on : Aug 17, 2022, 4:10:33 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/resources/js/main.js"/>"></script>
<div class="container pt-4 mt-3 row ">
    <div class="col-md-8">
        <h1>Thêm thành viên</h1>

        <div class="col">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Tạo nhóm</button>
        </div>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>UserName</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${user}" var="u">
                    <tr>
                        <td class="col-2">${u[0]}</td>
                        <td class="col-3">${u[1]}</td>
                        <td class="col-2">${u[2]}</td>
                        <td class="col-2">${u[3]}</td>
                        <td class="col-2">
                            <a href="#" onclick="addToTeam(${u[4]}, '${u[3]}', '${u[2]}')"><button type="button" class="btn btn-primary btn-add" onclick="changeButton()">Thêm vào nhóm</button></a>
                        </td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>
    </div>
    
    <div class="col-md-4 text-center">
        <h1 class="text-left text-info mb-8">Thao tác nhóm</h1>
        <a href="<c:url value="/user/expenseTeamList"/>"><button class="btn btn-outline-primary mt-4" style="width: 60%; height: 70px;">Quản lý chi</button></a>
        <a href="<c:url value="/user/incomeTeamList"/>"><button class="btn btn-outline-success mt-4" style="width: 60%; height: 70px;">Quản lý thu</button></a>
        <a href="<c:url value="/user/statsExpenseTeam"/>"><button class="btn btn-outline-warning mt-4" style="width: 60%; height: 70px;">Thống kê</button></a>
        <a href="<c:url value="/user/calendar"/>"><button class="btn btn-outline-danger mt-4" style="width: 60%; height: 70px;">Lịch</button></a>
        <a href="<c:url value="/user/chat"/>"><button class="btn btn-outline-secondary mt-4" style="width: 60%; height: 70px;">Chat nhóm</button></a>
    </div>


    <div class="myForm">
        <c:url value="team" var="action" />
        <form:form method="post" action="${action}" modelAttribute="team">
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Tạo nhóm</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="mb-3 mt-3">
                                <label for="name" class="form-label">Tên nhóm</label>
                                <form:input path="name" class="form-control" placeholder="Enter name" id="name"/>
                            </div>
                            <div class="mt-3">
                                <label for="description" class="form-label">Mô tả</label>
                                <form:textarea path="description" class="form-control" rows="5" id="description" name="text"></form:textarea>
                                </div>
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <a href="<c:url value="/user/listTeam"/>"><button type="submit" class="btn btn-primary">Submit</button></a>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Đóng</button>
                            </div>
                        </div>
                    </div>
                </div>
        </form:form>
    </div>

</div>

