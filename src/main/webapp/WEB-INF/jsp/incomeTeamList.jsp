<%-- 
    Document   : incomeTeamList
    Created on : Sep 2, 2022, 12:19:13 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container pt-4 mt-3">
        <h1>Danh sách chi của nhóm</h1>
        <div class="form-group row">
            <div class="col">
                <a href="<c:url value="/user/addIncomeTeam"/>"><button type="submit" class="btn btn-primary">Add new</button></a>
            </div>
            <c:url value="/" var="action" />
            <div class="col col-1">
                <form action="${action}" id="form1">
                    <% int rows = request.getParameter("rows") == null ? 5 : Integer.parseInt(request.getParameter("rows"));%>
                    <select class="form-select" name="rows" onchange="form1.submit();">
                        <option value="10" <%=rows == 10 ? "selected" : ""%>>10</option>
                        <option value="20" <%=rows == 20 ? "selected" : ""%>>20</option>
                        <option value="50" <%=rows == 50 ? "selected" : ""%>>50</option>
                        <option value="100" <%=rows == 100 ? "selected" : ""%>>100</option>
                        <option value="${counter}"> All</option>
                    </select>
                </form>
            </div>
        </div>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Income Name</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>UserName</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${incomeTeam}" var="it">
                    <tr>
                        <td class="col-2">${it[0]}</td>
                        <td class="col-3">${it[1]} VNĐ</td>
                        <td class="col-2">${it[2]}</td>
                        <td class="col-2">${it[3]}</td>
                        <td class="col-2">
                            <a href="<c:url value="/user/editIncomeTeam/${it[4]}"/>"><button class="btn btn-light">Edit</button></a>
                            <a href="<c:url value="/user/deleteIncomeTeam/${it[4]}"/>"><button class="btn btn-danger">Delete</button></a>
                            <a href="<c:url value="/user/detailsIncomeTeam/${it[4]}"/>"><button class="btn btn-warning">Details</button></a>
                        </td>
                    </tr>
                </c:forEach>       
            </tbody>
        </table>
        <div>
            <ul class="pagination pb-4">
                <c:forEach begin="1" end="${Math.ceil(counter/10)}" var="i">
                    <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${i}">${i}</a></li>
                    </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-1">
        <a href="<c:url value="/user/list"/>"><button class="btn btn-warning">Back</button></a>
    </div>
</body>
