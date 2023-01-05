<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product list</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <style>
  </style>
</head>
<body>
<div class="container align-items-center d-flex flex-column mt-3 table-responsive">
  <div class="row w-100">
    <h2 class="title col-12 text-center">Danh sách sản phẩm</h2>
  </div>
  <table class="table table-bordered table-light table-striped table-hover">
    <thead>
    <tr class="thead-dark">
      <th scope="col">ID</th>
      <th scope="col">Tên SP</th>
      <th scope="col">Giá</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Trạng thái</th>
      <th scope="col">Mô tả</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope['products'].values()}" var="product">
      <c:set value="${product.getId()}" var="id"/>
      <c:if test="${product.isAvailable()==false}">
        <tr>
          <th scope="row">${id}</th>
          <td>
            <a href="${pageContext.request.contextPath}/products?action=view&id=${product.getId()}">
                ${product.getName()}
            </a>
          </td>
          <td>
            <fmt:formatNumber
                    value="${product.getPrice()}"
                    type="currency"
                    currencyCode="VND"
                    currencySymbol="VND"
                    pattern="###,### VND"
            />
          </td>
          <td>${product.getQuantity()}</td>
          <td>
              ${product.isAvailable()?"Có sẵn":"Không có sẵn"}
          </td>
          <td>${product.getDesc()}</td>
          <td>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/products?action=edit&id=${id}">Edit</a>
            <a class="btn btn-warning remove"
               onclick="return confirm('Are you sure?')"
               href="${pageContext.request.contextPath}/products?action=update&id=${id}&type=restore">Restore</a>
          </td>
        </tr>
      </c:if>
    </c:forEach>
    </tbody>

  </table>
  <div class="row col-12">
    <div class="w-50 row">
      <div class="col-3 p-1"><a class="btn btn-primary w-100 " href="${pageContext.request.contextPath}/products?action=add">Add</a></div>
      <div class="col-3 p-1"><a class="btn btn-secondary w-100 " href="${pageContext.request.contextPath}/products?action=removed">Removed</a></div>
      <div class="col-3 p-1"><a class="btn btn-secondary w-100 " href="${pageContext.request.contextPath}/products?action=viewAll">All</a></div>
      <div class="col-3 p-1"><a href="/" class="btn btn-primary w-100" >Trở lại</a></div>
    </div>
  </div>
</div>
<script>
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>