<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/12/2022
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm người dùng</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

</head>
<body>
<div class="container border p-2 mt-5">
  <h3 class="h3 text-center">Thêm người dùng mới</h3>
  <form class="row g-3" action="${pageContext.request.contextPath}/user?action=add" method="post">
    <div class="col-md-6">
      <label for="name" class="form-label">Tên người dùng</label>
      <input class="form-control" id="name" name="name"/>
    </div>
    <div class="col-md-6">
      <label for="id" class="form-label">ID</label>
      <input
              class="form-control"
              id="id"
              name="id"
              type="number"
      />
    </div>
    <div class="col-12">
      <label for="email" class="form-label">Email</label>
      <input
              type="email"
              class="form-control"
              id="email"
              name="email"
      />
    </div>
    <div class="col-9">
      <label for="country" class="form-label">Quốc gia</label>
      <input
              type="text"
              class="form-control"
              id="country"
              value="Việt Nam"
              name="country"
      />
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
