<%-- 
    Document   : listIncome
    Created on : Aug 19, 2022, 4:45:30 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container pt-4 mt-3">
        <h2>Danh sách thu</h2>
        <div class="form-group row">
            <div class="col">
                <a href="<c:url value="/user/income"/>"><button type="submit" class="btn btn-primary">Add new</button></a>
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
                    <th>Name</th>
                    <th>Amount</th>
                    <th>Category</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${income}" var="e">
                    <tr>
                        <td class="col-2">${e.name}</td>
                        <td class="col-3">${e.amount} VNĐ</td>
                        <td class="col-2">${e.categoryId.name}</td>
                        <td class="col-2">${e.date}</td>
                        <td class="col-2">
                            <a href="<c:url value="/user/editIncome/${e.id}"/>"><button class="btn btn-light">Edit</button></a>
                            <a href="<c:url value="/user/deleteIncome/${e.id}"/>"><button class="btn btn-danger">Delete</button></a>
                            <a href="<c:url value="/user/detailsIncome/${e.id}"/>"><button class="btn btn-warning">Details</button></a>
                        </td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>
        <div>
            <ul class="pagination pb-4">
                <c:forEach begin="1" end="${Math.ceil(counter/10)}" var="i">
                    <li class="page-item"><a class="page-link" href="<c:url value="/home"/>?page=${i}">${i}</a></li>
                    </c:forEach>
            </ul>
        </div>
    </div>
</body>

