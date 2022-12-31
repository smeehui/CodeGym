<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/12/2022
  Time: 13:30
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
<div class="container d-flex flex-column mt-5">
    <c:set var="product" value="${requestScope['product']}"/>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col" colspan="4">Chi tiết sản phẩm</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row" colspan="2">ID:</th>
            <td colspan="2">${product.getId()}</td>
        </tr>
        <tr>
            <th scope="row" colspan="2">Tên sản phẩm:</th>
            <td colspan="2">${product.getName()}</td>
        </tr>
        <tr>
            <th scope="row">Số lượng:</th>
            <td>${product.getQuantity()}</td>
            <th scope="row">Giá:</th>
            <td>
                <fmt:formatNumber
                        value="${product.getPrice()}"
                        type="currency"
                        currencyCode="VND"
                        currencySymbol="VND"
                        pattern="###,### VND"
                />
            </td>
        </tr>
        <tr>
            <th scope="riPhone 11ow" colspan="2">Trạng thái:</th>
            <td colspan="2">${product.isAvailable()?'Có sẵn':'Không có sẵn'}</td>
        </tr>
        <tr>
            <th scope="row" colspan="2">Mô tả:</th>
            <td colspan="2">
                ${product.getDesc()}
            </td>
        </tr>
        </tbody>
        <tr>
            <td colspan="4"><a href="/" class="btn btn-primary">Danh sách sản phẩm</a> </td>
        </tr>
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
