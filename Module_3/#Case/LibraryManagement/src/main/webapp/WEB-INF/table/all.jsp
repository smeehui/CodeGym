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
                                                               data-bs-toggle="modal"
                                                               data-bs-target="#verticalycentered"
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
                                                    <c:choose>
                                                        <c:when test="${!book.isDeleted()}">
                                                            <i
                                                                    class="bi bi-x-circle-fill btn-sm btn btn-warning text-white"
                                                                    data-bs-toggle="modal"
                                                                    data-bs-target="#verticalycentered"
                                                                    data-name="${book.getTitle()}"
                                                                    data-id="${book.getId()}"
                                                                    data-type="book"
                                                                    onclick="confirmDelete(event)"
                                                            ></i>
                                                        </c:when>
                                                        <c:when test="${book.isDeleted()}">
                                                            <i class="bi bi-arrow-repeat text-white  btn-sm btn btn-warning"
                                                               data-bs-toggle="modal"
                                                               data-bs-target="#verticalycentered"
                                                               data-name="${book.getTitle()}"
                                                               data-id="${book.getId()}"
                                                               onclick="confirmRestore(event)"
                                                               data-type="book"
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
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Ngày thêm</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col" class="text-center">Quản lý</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="bookItem" items="${requestScope['bookItems'].values()}">
                                        <tr>
                                            <td class="bItemId">${bookItem.getId()}</td>
                                            <td>${bookItem.getBookId()}</td>
                                            <td class="bItemFormat"
                                                data-bformat="${bookItem.getFormat()}">${applicationScope['bookFormats'].get(bookItem.getFormat())}</td>
                                            <td class="bItemPublisher">${bookItem.getPublisher()}</td>
                                            <td class="bItemPublishedDate">${bookItem.getPublishedDate()}</td>
                                            <td class="bItemNoOfPage">${bookItem.getNumberOfPages()}</td>
                                            <td class="bItemPrice">${bookItem.getPrice()}</td>
                                            <fmt:parseDate value="${bookItem.getDateAdded()}"
                                                           pattern="yyyy-MM-dd'T'HH:mm" var="dateAdded"/>
                                            <td class="bItemQuantity">${bookItem.getQuantity()}</td>
                                            <td class="bItemDayAdded" data-dateadded="${dateAdded}"><fmt:formatDate value="${dateAdded}" pattern="yyyy-MM-dd HH:mm"/></td>
                                            <td class="bItemAvailable"
                                                data-bitemavailable="${bookItem.isAvailable()}">${bookItem.isAvailable()?"Có sẵn":"Không có sẵn"}</td>
                                            <td>
                                                <div class="container-fluid d-flex justify-content-between">
                                                    <button class="btn btn-primary btn-sm"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#bookItemModal"
                                                            data-bItemId="${bookItem.getId()}"
                                                            onclick="showBookItemDetails(event)"
                                                    >
                                                        <i class="bi bi-pencil-fill w-100" style="height: 30px"></i>
                                                    </button>
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
                                            <td class="bItemPublishedDate" hidden>
                                                <fmt:parseDate value="${bookItem.getPublishedDate()}"
                                                               pattern="yyyy-MM-dd" var="dateAdded"/>
                                                ${dateAdded}
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- End Default Table Example -->
                            </div>
                        </div>
                        <div class="modal fade" id="bookItemModal" tabindex="-1" aria-labelledby="bookItemModalLabel"
                             style="display: none;" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="bookItemModalLabel">
                                            Chỉnh sửa sách mượn
                                        </h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="col-lg-12">
                                            <form id="bItemForm" action="${pageContext.request.contextPath}/book_item?action=edit" method="post">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="mb-3 col-sm-6">
                                                                <label for="inputPublisher" class="col-form-label">Nhà
                                                                    XB</label>
                                                                <div class="">
                                                                    <input required name="bItemPublisher"
                                                                           id="inputPublisher" type="text"
                                                                           class="form-control" value="">
                                                                </div>
                                                            </div>
                                                            <div class="mb-3 col-sm-6">
                                                                <label for="inputDayPublished" class="col-form-label">Ngày
                                                                    XB</label>
                                                                <div class="">
                                                                    <input required name="bItemPublishedDate"
                                                                           id="inputDayPublished" type="date"
                                                                           class="form-control" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="mb-3 col-sm-6">
                                                                <label for="inputPage" class="col-form-label">Số
                                                                    trang</label>
                                                                <div class="">
                                                                    <input required name="bItemPages" id="inputPage"
                                                                           type="number" class="form-control" value="">
                                                                </div>
                                                            </div>
                                                            <div class="mb-3 col-sm-6">
                                                                <label for="inputPrice" class="col-form-label">Giá
                                                                    mượn</label>
                                                                <div class="">
                                                                    <input required name="bItemPrice" id="inputPrice"
                                                                           type="number" class="form-control" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-3">
                                                            <div class="col-sm-6">
                                                                <label for="inputFormat" class="col-form-label">Định
                                                                    dạng</label>
                                                                <div class="">
                                                                    <select id="inputFormat" class="form-select" required
                                                                            name="bItemFormat"
                                                                            aria-label="Default select example">
                                                                        <option selected="">
                                                                            Định
                                                                            dạng
                                                                            sách
                                                                        </option>
                                                                        <c:forEach
                                                                                items="${applicationScope['bookFormats']}"
                                                                                var="bookFormat">
                                                                            <option value="${bookFormat.getKey()}">${bookFormat.getValue()}</option>
                                                                        </c:forEach>

                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label for="inputQuantity" class="col-form-label">Số
                                                                    lượng</label>
                                                                <div class="">
                                                                    <input required name="bItemQuantity" id="inputQuantity"
                                                                           type="number" class="form-control" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row mb-3 col-sm-12">
                                                            <label class="col-form-label col-sm-3 pt-0">
                                                                Trạng
                                                                thái
                                                            </label>
                                                            <div class="form-control col-sm-12">
                                                                <div class="form-check col-sm-6">
                                                                    <input required class="form-check-input" type="radio"
                                                                           name="bIAvailable" id="bIavailable" value="true">
                                                                    <label class="form-check-label" for="bIavailable">
                                                                        Có
                                                                        thể
                                                                        mượn
                                                                    </label>
                                                                </div>
                                                                <div class="form-check col-sm-6">
                                                                    <input required class="form-check-input" type="radio"
                                                                           name="bIAvailable" id="bINotAvailable"
                                                                           value="false">
                                                                    <label class="form-check-label" for="bINotAvailable">
                                                                        Chưa
                                                                        mượn
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="reset" form="bItemForm" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Hủy
                                        </button>
                                        <button type="submit" form="bItemForm" class="btn btn-primary">
                                            Save changes
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                </c:choose>
                <jsp:include page="/WEB-INF/layout/pagination_nav.jsp"/>
                <div class="modal fade" id="verticalycentered" tabindex="-1" style="display: none;" aria-hidden="true">
                    <form id="confirm-delete-form" method="post">
                        <c:forEach items="${requestScope.entrySet()}" var="parameter">
                            <c:if test="${!(parameter.getKey().contains('jakarta')||parameter.getKey().contains('users'))}">
                                <input hidden name="${parameter.getKey()}" value="${parameter.getValue()}">
                            </c:if>
                        </c:forEach>
                        <c:if test="${param.deleted!=null}">
                            <input hidden name="deleted" value="${param.deleted}">
                        </c:if>
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
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-primary" id="delete-confirm-btn">Xác nhận
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
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
        document.getElementById("confirm-delete-form").setAttribute("action", "${pageContext.request.contextPath}/" + type + "?action=delete&id=" + id)
    }

    function confirmRestore(e) {
        console.log(e.target)
        let id = e.target.dataset.id;
        let name = e.target.dataset.name;
        let type = e.target.dataset.type;
        document.getElementById("modal-title").innerText = "Xác nhận khôi phục";
        document.getElementById("modal-action").innerText = "khôi phục";
        document.getElementById("deleted-item").innerText = name;
        document.getElementById("confirm-delete-form").setAttribute("action", "${pageContext.request.contextPath}/" + type + "?action=delete&id=" + id)
    }
    function showBookItemDetails(e){
        let row = e.currentTarget.closest("tr");
        let bItemId = row.querySelector(".bItemId").innerText
        let bItemPublisher = row.querySelector(".bItemPublisher").innerText
        let bItemFormat = row.querySelector(".bItemFormat").dataset.bformat
        let bItemPrice = row.querySelector(".bItemPrice").innerText
        let bItemNoOfPage = row.querySelector(".bItemNoOfPage").innerText
        let bItemQuantity = row.querySelector(".bItemQuantity").innerText
        let bItemAvailable = row.querySelector(".bItemAvailable").dataset.bitemavailable
        let bItemDayAdded = row.querySelector(".bItemDayAdded").dataset.dateadded
        let bItemPublishedDate = row.querySelector(".bItemPublishedDate").innerText
        console.log(bItemId,bItemFormat,bItemPublisher,bItemPrice,bItemAvailable)
        document.getElementById("inputPublisher").value = bItemPublisher
        document.getElementById("inputDayPublished").value =bItemPublishedDate
        document.getElementById("inputPage").value = bItemFormat
        document.getElementById("inputPrice").value = bItemPrice
        document.getElementById("inputFormat").value = bItemFormat
        document.getElementById("inputQuantity").value =bItemQuantity
        document.getElementById("bIavailable").value = bItemAvailable
    }



</script>
</body>
</html>
