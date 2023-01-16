<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 16/01/2023
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit product</title>
  <jsp:include page="/WEB-INF/layout/header_link.jsp"/>
</head>
<body>
<div class="container mt-3">
  <jsp:include page="/WEB-INF/layout/notification.jsp"/>
  <c:set var="product" value="${requestScope['product']}"/>
  <form class="form-sm" method="post" action="${pageContext.request.contextPath}/product?action=edit&id=${product.getId()}">
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" value="${product.getName()}" name="name">
    </div>
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="number" value="${product.getPrice()}" name="price" class="form-control" id="price">
    </div>
    <div class="mb-3">
      <label for="inputQuantity" class="form-label">Quantity</label>
      <input type="number" value="${product.getQuantity()}" name="quantity" class="form-control" id="inputQuantity">
    </div>
    <div class="mb-3">
      <label for="Color" class="form-label">Color</label>
      <input type="text" value="${product.getColor()}" name="color" class="form-control" id="Color">
    </div>
    <div class="mb-3">
      <label for="inputDesc" class="form-label">Description</label>
      <textarea id="inputDesc" name="desc" class="form-control">${product.getDesc()}</textarea>
    </div>
    <div class="mb-3">
      <label for="category" class="form-label">Categories</label>
      <select class="form-control" value="${product.getCategory()}" name="category" id="category">
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
  <div>
    <% int x=5; %>
    <%=x%>
  </div>
</div>
<jsp:include page="/WEB-INF/layout/script.jsp"/>
<jsp:include page="/WEB-INF/layout/toast_trigger.jsp"/>
</body>
</html>
