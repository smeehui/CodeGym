<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <style>
        .container{
            margin-left: auto;
            margin-right: auto;
            width: 650px;
            border-radius: 10px;
            box-shadow: 0 0 5px #333;
        }
        table{
           width: 100%;
            border-collapse: collapse;
        }
        table caption{
            padding: 5px;
            font-weight: bold;
            letter-spacing: 1px;
            margin-bottom: 10px;
        }
        table tr{
            border-bottom: 1px solid #ccc;
            height: 75px;
            padding: 0 5px;
        }
        tr td{
            padding: 5px;
        }
        img{
            width:75px;
        }
        .name{
            width: 200px;
        }
        .address{
            width: 150px;
        }
    </style>
</head>
<body>
    <div class="container">
        <table>
            <caption>Danh sách khách hàng</caption>
            <thead>
            <td class="name">Tên</td>
            <td class="dob">Ngày sinh</td>
            <td class="address">Địa chỉ</td>
            <td class="photo">Ảnh</td>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.customers}" var="cus">
                <tr>
                    <td >${cus.getName()}</td>
                    <td >${cus.getDOB()}</td>
                    <td >${cus.getAddress()}</td>
                    <td >
                        <img src="${cus.getImg()}" alt="avt">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>