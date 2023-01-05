<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/12/2022
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope['product'].getName()}</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container border p-2 mt-5">
    <c:set var="product" value="${requestScope['product']}"/>
    <h3 class="h3 text-center">Sửa thông tin sản phẩm</h3>
    <form class="row g-3" action="${pageContext.request.contextPath}/products?action=edit" method="post">
        <div class="col-md-6">
            <label for="name" class="form-label">Tên sản phẩm</label>
            <input class="form-control" id="name" name="name" value="${product.getName()}"/>
        </div>
        <div class="col-md-6">
            <label for="quantity" class="form-label">Số lượng</label>
            <input
                    class="form-control"
                    id="quantity"
                    name="quantity"
                    type="number"
                    value="${product.getQuantity()}"
            />
        </div>
        <div class="col-12">
            <label for="price" class="form-label">Giá</label>
            <fmt:formatNumber type="NUMBER" scope="session" pattern="######" value="${product.getPrice()}" var="priceFmt" />
            <c:set var="price" value="${priceFmt}"/>
            <input
                    type="number"
                    class="form-control"
                    id="price"
                    name="price"
                    value="${price}"
            />
        </div>
        <div class="col-9">
            <label for="desc" class="form-label">Mô tả</label>
            <input
                    type="text"
                    class="form-control"
                    id="desc"
                    name="desc"
                    value = "${product.getDesc()}"
            />
        </div>
        <input hidden name="id" value = "${product.getId()}"/>
        <div class="col-3">
            <label for="status" class="form-label">Mô tả</label>
            <select
                    id="status"
                    class="form-select form-control"
                    name="available"
            >
                <option selected>Choose...</option>
                <option value="true">Có sẵn</option>
                <option value="false">Không có sẵn</option>
            </select>
        </div>

        <div class="col-12 mt-2">
            <button type="submit" class="btn btn-primary">
                Xác nhận
            </button>
        </div>
    </form>
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
