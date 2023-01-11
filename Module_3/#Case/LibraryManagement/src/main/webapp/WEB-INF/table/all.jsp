<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Tables / General - NiceAdmin Bootstrap Template</title>
    <jsp:include page="/WEB-INF/layout/head_link.jsp"/>
</head>

<body>
<!-- ======= Header ======= -->
<jsp:include page="/WEB-INF/layout/header.jsp"/><!-- End Header -->

<!-- ======= Sidebar ======= -->
<jsp:include page="/WEB-INF/layout/side_bar.jsp"/><!-- End Sidebar-->

<main id="main" class="main">
    <div class="pagetitle">
        <h1>General Tables</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">Home</a>
                </li>
                <li class="breadcrumb-item">Tables</li>
                <li class="breadcrumb-item active">General</li>
            </ol>
        </nav>
    </div>
    <!-- End Page Title -->

    <section class="section">
        <div class="row">
            <jsp:include page="/WEB-INF/layout/filter.jsp"/>
            <div class="col-lg-12 position-relative" style="font-size: 0.8rem" id="info-table">
                <c:set var="view" value="${requestScope['view']}"/>
                <c:choose>
                    <c:when test="${view=='user'}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Danh sách người dùng</h5>
                                <!-- Default Table -->
                                <table class="table table-sm table-bordered">
                                    <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Tên đầy đủ</th>
                                        <th scope="col">Số điện thoại</th>
                                        <th scope="col">Địa chỉ</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Quyền</th>
                                        <th scope="col" class="text-center">Quản lý</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${requestScope['users'].values()}">
                                        <tr
                                                <c:if test="${user.isDeleted()}">style="color: var(--bs-danger);opacity: 0.6"</c:if>
                                        >
                                            <td>${user.getId()}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/user?action=view?id=${user.getId()}">${user.getFullName()}</a>
                                            </td>
                                            <td>${user.getMobile()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${sessionScope["roles"].get(user.getRole()).getName()}</td>
                                            <td>
                                                <div class="d-flex justify-content-evenly container-fluid align-items-center">

                                                    <a class="btn-sm btn btn-primary"
                                                       href="${pageContext.request.contextPath}/user?action=edit&id=${user.getId()}">
                                                        <i class="bi bi-person-gear"></i>
                                                    </a>
                                                    <c:choose>
                                                        <c:when test="${!user.isDeleted()}">
                                                            <i
                                                                    class="bi bi-person-fill-x text-white  btn-sm btn btn-warning"
                                                                    data-bs-toggle="modal"
                                                                data-bs-target="#verticalycentered"
                                                                data-name="${user.getFullName()}"
                                                                data-id="${user.getId()}"
                                                                data-type="user"
                                                                onclick="confirmDelete(event)"
                                                        ></i>
                                                    </c:when>
                                                    <c:when test="${user.isDeleted()}">
                                                        <i class="bi bi-arrow-left-square-fill text-white  btn-sm btn btn-warning"
                                                           data-bs-toggle="modal" data-bs-target="#verticalycentered"
                                                           data-name="${user.getFullName()}"
                                                           data-id="${user.getId()}"
                                                           onclick="confirmRestore(event)"
                                                           data-type="user"
                                                        ></i>
                                                    </c:when>
                                                </c:choose>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- End Default Table Example -->
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${view=='book'}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Danh sách người dùng</h5>

                                <!-- Default Table -->
                                <table class="table table-sm table-bordered">
                                    <thead>
                                    <tr>
                                        <th scope="col">ISBN</th>
                                        <th scope="col">Tiêu đề</th>
                                        <th scope="col">Tác giả</th>
                                        <th scope="col">Thể loại</th>
                                        <th scope="col">Ngôn ngữ</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col" class="text-center">Quản lý</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="book" items="${requestScope['books'].values()}">
                                        <tr
                                                <c:if test="${book.isDeleted()}">style="color: var(--bs-danger);opacity: 0.6"</c:if>
                                        >
                                            <td>${book.getIsbn()}</td>
                                            <td>${book.getTitle()}</td>
                                            <td>${book.getAuthor()}</td>
                                            <td>${book.getSubject()}</td>
                                            <td>${book.getLanguage()}</td>
                                            <td>${book.isAvailable()?"Có sẵn":"Không có sẵn"}</td>
                                            <td>
                                                <div class="container-fluid d-flex justify-content-evenly h-100">
                                                    <a class="btn-sm btn btn-primary"
                                                       href="${pageContext.request.contextPath}/book?action=edit&id=${book.getId()}">
                                                        <i class="bi bi-pencil-fill "></i>
                                                    </a>
                                                    <i
                                                            class="bi bi-x-circle-fill btn-sm btn btn-warning text-white"
                                                            data-bs-toggle="modal" data-bs-target="#verticalycentered"
                                                            data-name="${book.getTitle()}"
                                                            data-id="${book.getId()}"
                                                            data-type="book"
                                                            onclick="confirmDelete(event)"
                                                    ></i>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- End Default Table Example -->
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${view=='bookItem'}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Danh sách sách mượn</h5>

                                <!-- Default Table -->
                                <table class="table table-sm table-bordered">
                                    <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Tên sách</th>
                                        <th scope="col">Định dạng</th>
                                        <th scope="col">Nhà XB</th>
                                        <th scope="col">Ngày XB</th>
                                        <th scope="col">Số trang</th>
                                        <th scope="col">Giá mượn</th>
                                        <th scope="col">Ngày thêm</th>
                                        <th scope="col">Ngày chỉnh sửa</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col" class="text-center">Quản lý</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="bookItem" items="${requestScope['bookItems'].values()}">
                                        <tr>
                                            <td>${bookItem.getId()}</td>
                                            <td>${bookItem.getBookId()}</td>
                                            <td>${applicationScope['bookFormats'].get(bookItem.getFormat())}</td>
                                            <td>${bookItem.getPublisher()}</td>
                                            <td>${bookItem.getPublishedDate()}</td>
                                            <td>${bookItem.getNumberOfPages()}</td>
                                            <td>${bookItem.getPrice()}</td>
                                            <fmt:parseDate value="${bookItem.getDateAdded()}"
                                                           pattern="yyyy-MM-dd'T'HH:mm" var="dateAdded"/>
                                            <td><fmt:formatDate value="${dateAdded}" pattern="yyyy-MM-dd HH:mm"/></td>
                                            <fmt:parseDate value="${bookItem.getDateAdded()}"
                                                           pattern="yyyy-MM-dd'T'HH:mm" var="dateModified"/>
                                            <td><fmt:formatDate value="${dateModified}"
                                                                pattern="yyyy-MM-dd HH:mm"/></td>
                                            <td>${bookItem.isAvailable()?"Có sẵn":"Không có sẵn"}</td>
                                            <td>
                                                <div class="container-fluid d-flex justify-content-evenly h-100">
                                                    <a class="btn btn-sm btn-primary"
                                                       href="${pageContext.request.contextPath}/book?action=edit&id=${bookItem.getId()}">
                                                        <i class="bi bi-pencil-fill "></i>
                                                    </a>
                                                    <i
                                                            class="bi bi-x-circle-fill btn btn-sm btn-warning text-white"
                                                            data-bs-toggle="modal" data-bs-target="#verticalycentered"
                                                            data-name="${bookItem.getBookId()}"
                                                            data-id="${bookItem.getId()}"
                                                            data-type="book"
                                                            onclick="confirmDelete(event)"
                                                    ></i>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- End Default Table Example -->
                            </div>
                        </div>
                    </c:when>
                </c:choose>
                <jsp:include page="/WEB-INF/layout/pagination_nav.jsp"/>
                <div class="modal fade" id="verticalycentered" tabindex="-1" style="display: none;" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="modal-title">Xác nhận xoá.</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn chắc chắn muốn <span id="modal-action"></span> <span id="deleted-item"></span>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <a class="btn btn-primary" id="delete-confirm-btn">Xác nhận</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="/WEB-INF/layout/footer.jsp"/>
<!-- Vendor JS Files -->
<jsp:include page="/WEB-INF/layout/script.jsp"/>

<script>
    function confirmDelete(e) {
        console.log(e.target)
        let id = e.target.dataset.id;
        let name = e.target.dataset.name;
        let type = e.target.dataset.type;
        document.getElementById("modal-title").innerText = "Xác nhận xóa";
        document.getElementById("modal-action").innerText = "xóa";
        document.getElementById("deleted-item").innerText = name;
        document.getElementById("delete-confirm-btn").setAttribute("href", "${pageContext.request.contextPath}/" + type + "?action=delete&id=" + id)
    }

    function confirmRestore(e) {
        console.log(e.target)
        let id = e.target.dataset.id;
        let name = e.target.dataset.name;
        let type = e.target.dataset.type;
        document.getElementById("modal-title").innerText = "Xác nhận khôi phục";
        document.getElementById("modal-action").innerText = "khôi phục";
        document.getElementById("deleted-item").innerText = name;
        document.getElementById("delete-confirm-btn").setAttribute("href", "${pageContext.request.contextPath}/" + type + "?action=delete&id=" + id)
    }

</script>
</body>
</html>
