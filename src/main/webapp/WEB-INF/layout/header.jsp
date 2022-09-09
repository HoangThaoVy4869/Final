<%-- 
    Document   : header
    Created on : Aug 12, 2022, 4:21:32 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar-expand-lg nav-background">
    <div class="container-fluid nav-display">
        <div class="nav-title">
            <a href="<c:url value="/home"/>">Expensive Web Manager</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse nav-content" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll nav-gap" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/home"/>">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/home"/>">Khoản Chi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/user/incomeList"/>" tabindex="-1" aria-disabled="true">Khoản Thu</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thống Kê
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown" style="background-color: gainsboro">
                        <li><a class="dropdown-item" href="<c:url value="/user/statsExpense"/>">Thống Kê Khoản Chi</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/user/statsIncome"/>">Thống Kê Khoản Thu</a></li>
                    </ul>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Nhóm
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown" style="background-color: gainsboro">
                        <li><a class="dropdown-item" href="<c:url value="/user/list"/>">Tương tác nhóm</a></li>
                        <li>
                            <a class="dropdown-item" href="<c:url value="/user/listMembers"/>">Danh sách thành viên</a>
                        </li>
                        <li><a class="dropdown-item" href="<c:url value="/user/listTeam"/>">Danh sách nhóm</a></li>
                    </ul>
                </li>

                <sec:authorize access="hasAuthority('0')" >
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/admin/list"/>" tabindex="-1" aria-disabled="true">Quản lý người dùng</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">

                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/home"/>">
                            <c:if test="${currentUser.avatar != null}">
                                <img style="width: 30px; margin-right: 5px;" src="${currentUser.avatar}" class="img-fluid"/>
                            </c:if>

                            ${pageContext.request.userPrincipal.name}</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/logout"/>">Đăng xuất</a>
                    </li>
                </sec:authorize>
            </ul>

        </div>

    </div>
</nav>
<div class="nav-search">
    <form class="d-flex" action="">
        <input class="form-control me-2" name="kw" type="search" placeholder="Nhập từ khóa ......" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Tìm</button>
    </form>
</div>