<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/12/2022
  Time: 00:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope["customer"].getName()}</title>
</head>
<body>
<p>
  <a href="${pageContext.request.contextPath}/customers?action=view">Back to customer list</a>
</p>
<table>
  <tr>
    <td>Name: </td>
    <td>${requestScope["customer"].getName()}</td>
  </tr>
  <tr>
    <td>Email: </td>
    <td>${requestScope["customer"].getEmail()}</td>
  </tr>
  <tr>
    <td>Address: </td>
    <td>${requestScope["customer"].getAddress()}</td>
  </tr>
</table>
</body>
</html>
