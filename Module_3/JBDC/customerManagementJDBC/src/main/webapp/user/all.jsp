<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 03/01/2023
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container align-items-center d-flex flex-column mt-3 table-responsive">
    <c:set var="view" value="${requestScope['view']}"/>
    <div class="row w-100">
        <h2 class="title col-12 text-center">${view=='removed'?'Danh sách người dùng đã xóa':'Danh sách người dùng'}</h2>
    </div>
    <table class="table table-bordered table-light table-striped table-hover m-0">
        <thead>
        <tr class="thead-dark">
            <th scope="col">ID</th>
            <th scope="col">Tên KH<a class="text-right" href="${pageContext.request.contextPath}/user?action=sort&type=asc">Sort</a></th>
            <th scope="col">Email</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['users']}" var="user">
            <c:set value="${user.getId()}" var="id"/>
            <tr>
                <th scope="row">${id}</th>
                <td>
                    <a href="${pageContext.request.contextPath}/user?action=view&id=${user.getId()}">
                            ${user.getName()}
                    </a>
                </td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
                <td>
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/user?action=edit&id=${id}">Edit</a>
                    <a class="btn btn-warning remove"
                       onclick="return confirm('Are you sure?')"
                       href="${pageContext.request.contextPath}/user?action=${view=="removed"?"restore":"remove"}&id=${id}">${view=="removed"?"Restore":"Remove"}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row col-12 bg-dark">
        <div class="col-6 row align-items-center">
            <div class="col-3 p-1"><a class="btn btn-primary w-100 "
                                      href="${pageContext.request.contextPath}/user?action=add">Add</a></div>
            <div class="col-3 p-1"><a class="btn btn-secondary w-100 "
                                      href="${pageContext.request.contextPath}/user?action=removed">Removed</a></div>
            <div class="col-3 p-1"><a href="/" class="btn btn-primary w-100">Refresh</a></div>
        </div>
        <div class="col-6 row align-items-center">
            <form class="d-flex w-100 p-1 m-0" role="search" action="${pageContext.request.contextPath}/products" method="get">
                <input class="form-control me-2 d-none" name="action" value="search">
                <input class="form-control me-2" type="search" placeholder="Search" name="q" aria-label="Search" value="${requestScope['query']}">
                <button class="btn btn-outline-success ml-2" type="submit">Search</button>
            </form>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</html>
