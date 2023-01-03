<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/12/2022
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa ${requestScope['customer'].getName()}</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/customers?action=delete">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope["customer"].getAddress()}</td>
            </tr>
            <tr>
                <input style="display: none" type="number" name="id" value="${requestScope["customer"].getId()}">
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="${pageContext.request.contextPath}/customers?action=view">Back to customer list</a></td>
            </tr>
        </table>
        <c:if test="${requestScope.get('message')!=null}">
            <p><c:out value="${requestScope.get('message')}"/></p>
        </c:if>
    </fieldset>
</form>
</body>
</html>
