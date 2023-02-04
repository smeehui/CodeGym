<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 16/01/2023
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
  <jsp:include page="/WEB-INF/layout/header_link.jsp"/>
</head>
<body class="">
    <div class="container mt-3 position-relative">

        <jsp:include page="/WEB-INF/layout/notification.jsp"/>
        <form class="form-sm" method="post" action="${pageContext.request.contextPath}/product?action=add">
            <div class="mb-3">
                <label for="inputName" class="form-label">Name</label>
                <input type="text" class="form-control" id="inputName" name="name">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="number" name="price" class="form-control" id="price">
            </div>
            <div class="mb-3">
                <label for="inputQuantity" class="form-label">Quantity</label>
                <input type="number" name="quantity" class="form-control" id="inputQuantity">
            </div>
            <div class="mb-3">
                <label for="Color" class="form-label">Color</label>
                <input type="text" name="color" class="form-control" id="Color">
            </div>
            <div class="mb-3">
                <label for="inputDesc" class="form-label">Description</label>
               <textarea id="inputDesc" name="desc" class="form-control"></textarea>
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Categories</label>
                <select class="form-control" name="category" id="category">
                    <c:forEach items="${applicationScope['categories']}" var="category">
                        <option value="${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/product" class="btn btn-primary">Back</a>
            </div>
        </form>
    </div>
<jsp:include page="/WEB-INF/layout/script.jsp"/>
<jsp:include page="/WEB-INF/layout/toast_trigger.jsp"/>
</body>
</html>
