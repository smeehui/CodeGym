<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 29/12/2022
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa ${requestScope['customer'].getName()}</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/customers?action=edit">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope['customer'].getName()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope['customer'].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope['customer'].getAddress()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
            <tr style="display: none">
                <td><input type="number" name="id" id="id" value="${requestScope['customer'].getId()}"></td>
            </tr>
        </table>
        <p><c:out value="${requestScope.get('message')}"/></p>
    </fieldset>
    <a href="/customers?action=view"> Trở lại</a>
</form>
</body>
</html>
