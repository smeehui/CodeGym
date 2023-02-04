<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 29/12/2022
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <style><%@include file="./css/style.css"%></style>
</head>
<body>
    <div class="container">
        <table>
            <caption>
                Danh sách khách hàng
            </caption>
            <thead>
            <tr>
                <td>Tên KH</td>
                <td>Địa chỉ</td>
                <td>Email</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope['customers']}" var="customer">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/customers?action=view_customer&id=${customer.getId()}">${customer.getName()}</a></td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td><a href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.getId()}">edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/customers?action=delete&id=${customer.getId()}">delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" style="text-align: center"><a href="${pageContext.request.contextPath}/customers?action=create">Thêm mới</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
