<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 03/01/2023
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope["user"].getName()}</title>
    <link
            crossorigin="anonymous"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            rel="stylesheet"
    />
</head>
<body>
<c:set var="user" value="${requestScope['user']}"/>
<div
        class="container mt-5"
        style="box-shadow: 0 0 10px black; padding: 10px"
>
    <table class="table table-bordered table-light">
        <thead>
        <tr>
            <th class="text-center h3" scope="col" colspan="5">
                Chi tiết khách hàng
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">ID:</th>
            <td>${user.getId()}</td>
            <th style="width: fit-content">Tên đầy đủ:</th>
            <td colspan="2">${user.getName()}</td>
        </tr>
        <tr>
            <th scope="row">Email:</th>
            <td colspan="4">${user.getEmail()}</td>
        </tr>
        <tr>
            <th scope="row">Quốc Gia</th>
            <td colspan="2">${user.getCountry()}</td>
            <th scope="row">Trạng thái</th>
            <td>${user.isStatus()?"Đang hoạt động":"Dừng hoạt động"}</td>
        </tr>
        </tbody>
    </table>
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
