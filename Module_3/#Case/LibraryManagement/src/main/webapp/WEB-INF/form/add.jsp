<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>Forms / Elements - NiceAdmin Bootstrap Template</title>
    <jsp:include page="/WEB-INF/layout/head_link.jsp"/>
</head>

<body>
<!-- ======= Header ======= -->
<jsp:include page="/WEB-INF/layout/header.jsp"/>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<jsp:include page="/WEB-INF/layout/side_bar.jsp"/>
<!-- End Sidebar-->

<main id="main" class="main position-relative">
    <c:set value="${requestScope['view']}" var="view"/>
    <div class="pagetitle">
        <h1>
            <c:choose>
                <c:when test="${view=='user'}">Đăng ký người dùng</c:when>
                <c:when test="${view=='book'}">Tạo mới sách</c:when>
                <c:when test="${view=='bookItem'}">Tạo mới sách mượn</c:when>
            </c:choose>
        </h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">Home</a>
                </li>
                <li class="breadcrumb-item">Forms</li>
                <li class="breadcrumb-item active">Elements</li>
            </ol>
        </nav>
    </div>
    <!-- End Page Title -->

    <section class="section">
        <div class="row">
            <c:choose>
                <c:when test="${view=='user'}">
                    <c:set var="user" value="${requestScope['user']}"/>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">
                                    Thêm thành viên
                                </h5>

                                <!-- General Form Elements -->
                                <form method="post">
                                    <div class="row mb-3">
                                        <label
                                                class="col-sm-2 col-form-label"
                                                for="inputName"
                                        >Tên đầy đủ</label
                                        >
                                        <div class="col-sm-4">
                                            <input required
                                                   name="userFullName"
                                                   id="inputName"
                                                   class="form-control"
                                                   type="text"
                                                   value="${user.getFullName()}"
                                            />

                                        </div>
                                        <label
                                                class="col-sm-2 col-form-label text-center border-start"
                                                for="inputAddress"
                                        >Địa chỉ</label
                                        >
                                        <div class="col-sm-4">
                                            <input required
                                                   name="userAddress"
                                                   id="inputAddress"
                                                   class="form-control"
                                                   type="text"
                                                   value="${user.getAddress()}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                class="col-sm-2 col-form-label"
                                                for="inputUsername"
                                        >Username</label
                                        >
                                        <div class="col-sm-10">
                                            <input required
                                                   id="inputUsername"
                                                   name="username"
                                                   class="form-control"
                                                   type="text"
                                                   value="${user.getUsername()}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                class="col-sm-2 col-form-label"
                                                for="inputPassword"
                                        >Password</label
                                        >
                                        <div class="col-sm-10">
                                            <input required
                                                   id="inputPassword"
                                                   name="userPassword"
                                                   class="form-control"
                                                   type="password"
                                                   value="${user.getPassword()}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                class="col-sm-2 col-form-label"
                                                for="inputEmail"
                                        >Email</label
                                        >
                                        <div class="col-sm-10">
                                            <input required
                                                   id="inputEmail"
                                                   name="userEmail"
                                                   class="form-control"
                                                   type="email"
                                                   value="${user.getEmail()}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                class="col-sm-2 col-form-label"
                                                for="inputNumber"
                                        >Số điện thoại</label
                                        >
                                        <div class="col-sm-10">
                                            <input required
                                                   id="inputNumber"
                                                   name="userNumber"
                                                   class="form-control"
                                                   type="number"
                                                   value="${user.getMobile()}"
                                            />
                                        </div>
                                    </div>
                                    <fieldset class="row mb-3">
                                        <legend
                                                class="col-form-label col-sm-2 pt-0"
                                        >
                                            Role
                                        </legend>
                                        <div class="col-sm-10 ">
                                            <div class="form-check d-inline-block m-x-3">
                                                <input required
                                                       name="role"
                                                        <c:if test="${user.getRole()==1}">
                                                            checked
                                                        </c:if>
                                                       class="form-check-input"
                                                       id="memberRole"
                                                       name="userRole"
                                                       type="radio"
                                                       value="1"
                                                />
                                                <label
                                                        class="form-check-label"
                                                        for="memberRole"
                                                >
                                                    Thành viên
                                                </label>
                                            </div>
                                            <div class="form-check d-inline-block">
                                                <input required
                                                        <c:if test="${user.getRole()==2}">
                                                            checked
                                                        </c:if>
                                                       name="role"
                                                       class="form-check-input"
                                                       id="adminRole"
                                                       name="userRole"
                                                       type="radio"
                                                       value="2"
                                                />
                                                <label
                                                        class="form-check-label"
                                                        for="adminRole"
                                                >
                                                    Thủ thư
                                                </label>
                                            </div>
                                        </div>
                                    </fieldset>

                                    <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label"
                                        ></label
                                        >
                                        <div class="col-sm-5">
                                            <button
                                                    class="btn btn-primary"
                                                    type="submit"
                                            >
                                                Thêm mới
                                            </button>
                                            <button
                                                    class="btn btn-primary"
                                                    type="reset"
                                            >
                                                Nhập lại
                                            </button>
                                        </div>
                                    </div>
                                </form>
                                <!-- End General Form Elements -->
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:when test="${view=='book'}">
                    <c:set var="book" value="${requestScope['book']}"/>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">
                                    General Form Elements
                                </h5>

                                <!-- General Form Elements -->
                                <form
                                        method="post"
                                        action="${pageContext.request.contextPath}/book?action=add"
                                        id="bookForm"
                                        novalidate
                                >
                                    <div
                                            class="row mb-3 justify-content-between"
                                    >
                                        <div class="row col-sm-6">
                                            <label
                                                    for="inputIsbn"
                                                    class="col-form-label"
                                            >ISBN</label
                                            >
                                            <div class="">
                                                <input
                                                        required
                                                        id="inputIsbn"
                                                        name="isbn"
                                                        type="text"
                                                        class="form-control"
                                                        value="${book.getIsbn()}"
                                                />
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label
                                                    for="inputTitle"
                                                    class="col-form-label"
                                            >Tiêu đề
                                            </label>
                                            <div class="">
                                                <input
                                                        required
                                                        name="bookTitle"
                                                        id="inputTitle"
                                                        type="text"
                                                        class="form-control"
                                                        value="${book.getTitle()}"
                                                />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                for="inputAuthor"
                                                class="col-sm-2 col-form-label"
                                        >Tác giả</label
                                        >
                                        <div class="col-sm-10">
                                            <input
                                                    required
                                                    name="bookAuthor"
                                                    id="inputAuthor"
                                                    type="text"
                                                    class="form-control"
                                                    value="${book.getAuthor()}"
                                            />
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label
                                                for="inputSubject"
                                                class="col-sm-2 col-form-label"
                                        >Thể loại</label
                                        >
                                        <div class="col-sm-4">
                                            <input
                                                    required
                                                    name="bookSubject"
                                                    id="inputSubject"
                                                    type="text"
                                                    class="form-control"
                                                    value="${book.getSubject()}"
                                            />
                                        </div>
                                        <label
                                                for="inputLanguage"
                                                class="col-sm-2 col-form-label text-center"
                                        >Ngôn ngữ</label
                                        >
                                        <div class="col-sm-4">
                                            <input
                                                    required
                                                    name="bookLanguage"
                                                    id="inputLanguage"
                                                    type="text"
                                                    class="form-control"
                                                    value="${book.getLanguage()}"
                                            />
                                        </div>
                                    </div>
                                    <fieldset class="row mb-3">
                                        <legend
                                                class="col-form-label col-sm-2 pt-0"
                                        >
                                            Trạng thái
                                        </legend>
                                        <div class="col-sm-10 d-flex">
                                            <div class="form-check">
                                                <input
                                                        required
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="isAvailable"
                                                        id="gridRadios1"
                                                        value="true"
                                                />
                                                <label
                                                        class="form-check-label"
                                                        for="gridRadios1"
                                                >
                                                    Có sẵn
                                                </label>
                                            </div>
                                            <div class="form-check mx-5">
                                                <input
                                                        required
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="isAvailable"
                                                        id="gridRadios2"
                                                        value="false"
                                                />
                                                <label
                                                        class="form-check-label"
                                                        for="gridRadios2"
                                                >
                                                    Không có sẵn
                                                </label>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <div class="row mb-3">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <!-- Button trigger modal -->
                                            <div class="btn btn-primary">
                                                <input
                                                        type="checkbox"
                                                        name="hasBookItem"
                                                        value="true"
                                                        id="includeBookItem"
                                                        class="form-check-input"
                                                />
                                                <label
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#bookItemModal"
                                                        for="includeBookItem"
                                                >
                                                    Tạo sách mượn
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <input
                                                    type="submit"
                                                    class="btn btn-primary"
                                                    value="Thêm mới"
                                            />
                                            <button
                                                    type="reset"
                                                    class="btn btn-primary"
                                            >
                                                Nhập lại
                                            </button>
                                        </div>
                                    </div>
                                    <div
                                            class="modal fade"
                                            id="bookItemModal"
                                            tabindex="-1"
                                            aria-labelledby="bookItemModalLabel"
                                            aria-hidden="true"
                                    >
                                        <div
                                                class="modal-dialog modal-dialog-centered"
                                        >
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5
                                                            class="modal-title"
                                                            id="bookItemModalLabel"
                                                    >
                                                        Thêm sách mượn
                                                    </h5>
                                                    <button
                                                            type="button"
                                                            class="btn-close"
                                                            data-bs-dismiss="modal"
                                                            aria-label="Close"
                                                    ></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="col-lg-12">
                                                        <div class="card">
                                                            <c:set value="${requestScope['bookItem']}" var="bookItem"/>
                                                            <div
                                                                    class="card-body"
                                                            >
                                                                <div
                                                                        class="row"
                                                                >
                                                                    <div
                                                                            class="mb-3 col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputPublisher"
                                                                                class="col-form-label"
                                                                        >Nhà
                                                                            XB</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    name="bItemPublisher"
                                                                                    id="inputPublisher"
                                                                                    type="text"
                                                                                    class="form-control"
                                                                                    value="${bookItem.getPublisher()}"
                                                                            />
                                                                        </div>
                                                                    </div>
                                                                    <div
                                                                            class="mb-3 col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputDayPublished"
                                                                                class="col-form-label"
                                                                        >Ngày
                                                                            XB</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    name="bItemPublishedDate"
                                                                                    id="inputDayPublished"
                                                                                    type="date"
                                                                                    class="form-control"
                                                                                    value="${bookItem.getPublishedDate()}"
                                                                            />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div
                                                                        class="row"
                                                                >
                                                                    <div
                                                                            class="mb-3 col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputPage"
                                                                                class="col-form-label"
                                                                        >Số
                                                                            trang</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    name="bItemPages"
                                                                                    id="inputPage"
                                                                                    type="number"
                                                                                    class="form-control"
                                                                                    value="${bookItem.getNumberOfPages()}"
                                                                            />
                                                                        </div>
                                                                    </div>
                                                                    <div
                                                                            class="mb-3 col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputPrice"
                                                                                class="col-form-label"
                                                                        >Giá
                                                                            mượn</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    name="bItemPrice"
                                                                                    id="inputPrice"
                                                                                    type="number"
                                                                                    class="form-control"
                                                                                    value="${bookItem.getPrice()}"
                                                                            />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div
                                                                        class="row mb-3"
                                                                >
                                                                    <div
                                                                            class="col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputFormat"
                                                                                class="col-form-label"
                                                                        >Định
                                                                            dạng</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <select
                                                                                    id="inputFormat"
                                                                                    class="form-select"
                                                                                    required
                                                                                    name="bItemFormat"
                                                                                    aria-label="Default select example"
                                                                            >
                                                                                <option
                                                                                        selected
                                                                                >
                                                                                    Định
                                                                                    dạng
                                                                                    sách
                                                                                </option>
                                                                                <c:forEach
                                                                                        items="${applicationScope['bookFormats'].keySet()}"
                                                                                        var="bookFormatKey">
                                                                                    <option <c:if
                                                                                            test="${bookItem.getFormat()== bookFormatKey}">selected</c:if>
                                                                                            value="${bookFormatKey}">${applicationScope['bookFormats'].get(bookFormatKey)}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                    <div
                                                                            class="col-sm-6"
                                                                    >
                                                                        <label
                                                                                for="inputQuantity"
                                                                                class="col-form-label"
                                                                        >Số
                                                                            lượng</label
                                                                        >
                                                                        <div
                                                                                class=""
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    name="bItemQuantity"
                                                                                    id="inputQuantity"
                                                                                    type="number"
                                                                                    class="form-control"
                                                                                    value="${bookItem.getQuantity()}"
                                                                            />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div
                                                                        class="row mb-3 col-sm-12"
                                                                >
                                                                    <label
                                                                            class="col-form-label col-sm-3 pt-0"
                                                                    >
                                                                        Trạng
                                                                        thái
                                                                    </label>
                                                                    <div
                                                                            class="form-control col-sm-12"
                                                                    >
                                                                        <div
                                                                                class="form-check col-sm-6"
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    class="form-check-input"
                                                                                    type="radio"
                                                                                    name="bIAvailable"
                                                                                    id="bIavailable"
                                                                                    value="true"
                                                                            />
                                                                            <label
                                                                                    class="form-check-label"
                                                                                    for="bIavailable"
                                                                            >
                                                                                Có
                                                                                thể
                                                                                mượn
                                                                            </label>
                                                                        </div>
                                                                        <div
                                                                                class="form-check col-sm-6"
                                                                        >
                                                                            <input
                                                                                    required
                                                                                    class="form-check-input"
                                                                                    type="radio"
                                                                                    name="bIAvailable"
                                                                                    id="bINotAvailable"
                                                                                    value="false"
                                                                            />
                                                                            <label
                                                                                    class="form-check-label"
                                                                                    for="bINotAvailable"
                                                                            >
                                                                                Chưa
                                                                                mượn
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button
                                                            type="reset"
                                                            class="btn btn-secondary"
                                                            data-bs-dismiss="modal"
                                                    >
                                                        Hủy
                                                    </button>
                                                    <button
                                                            type="button"
                                                            class="btn btn-primary"
                                                            data-bs-dismiss="modal"
                                                    >
                                                        Save changes
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <!-- End General Form Elements -->
                                <!-- Modal -->

                            </div>
                        </div>
                    </div>
                </c:when>
                <c:when test="${view=='bookItem'}">
                    <c:set var="bookItem" value="${requestScope['bookItem']}"/>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">
                                    General Form Elements
                                </h5>
                                <!-- General Form Elements -->
                                <form id="bItemForm" method="post" action="${pageContext.request.contextPath}/bookItem?action=add_bookitem">
                                    <c:set value="${requestScope['bookItem']}" var="bookItem"/>
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="mb-3 col-sm-6">
                                                    <label for="inputPublisher" class="col-form-label">Nhà
                                                        XB</label>
                                                    <div>
                                                        <input required="" name="bItemPublisher" id="inputPublisher" type="text" class="form-control" value="${bookItem.getPublisher()}">
                                                    </div>
                                                </div>
                                                <div class="mb-3 col-sm-6">
                                                    <label for="inputDayPublished" class="col-form-label">Ngày
                                                        XB</label>
                                                    <div class="">
                                                        <input required="" name="bItemPublishedDate" id="inputDayPublished" type="date" class="form-control" value="${bookItem.getPublishedDate()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="mb-3 col-sm-6">
                                                    <label for="inputPage" class="col-form-label">Số
                                                        trang</label>
                                                    <div class="">
                                                        <input required="" name="bItemPages" id="inputPage" type="number" class="form-control" value="${bookItem.getNumberOfPages()}">
                                                    </div>
                                                </div>
                                                <div class="mb-3 col-sm-6">
                                                    <label for="inputPrice" class="col-form-label">Giá
                                                        mượn</label>
                                                    <div class="">
                                                        <input required="" name="bItemPrice" id="inputPrice" type="number" class="form-control" value="${bookItem.getPrice()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-6">
                                                    <label for="inputFormat" class="col-form-label">Định
                                                        dạng</label>
                                                    <div class="">
                                                        <select id="inputFormat" class="form-select" required="" name="bItemFormat" aria-label="Default select example">
                                                            <option selected="">
                                                                Định
                                                                dạng
                                                                sách
                                                            </option>

                                                          <c:forEach var="bookFormat" items="${requestScope['bookFormats'].values()}">
                                                              <option value="${bookFormat.getValue()}">${bookFormat}</option>
                                                          </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="inputQuantity" class="col-form-label">Số
                                                        lượng</label>
                                                    <div class="">
                                                        <input required="" name="bItemQuantity" id="inputQuantity" type="number" class="form-control" value="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 p-3 row">
                                                <div class="col-sm-6">
                                                    <label class="col-form-label col-sm-3 pt-0">
                                                        Trạng thái
                                                    </label>
                                                    <div class="border border-light rounded">
                                                        <div class="form-check col-sm-6">
                                                            <input required="" class="form-check-input" type="radio" name="bIAvailable" id="bIavailable" value="true">
                                                            <label class="form-check-label" for="bIavailable">
                                                                Có sẵn
                                                            </label>
                                                        </div>
                                                        <div class="form-check col-sm-6">
                                                            <input required="" class="form-check-input" type="radio" name="bIAvailable" id="bINotAvailable" value="false">
                                                            <label class="form-check-label" for="bINotAvailable">
                                                                Chưa có sẵn
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label class="col-form-label col-sm-3 pt-0">
                                                        Chọn sách
                                                    </label>
                                                    <select class="form-control-lg form-select m-a m-auto" name="bookId">
                                                        <option value="">---Chọn sách tương ứng---</option>
                                                       <c:forEach var="book" items="${requestScope['books'].values()}">
                                                           <option value="${book.getId()}">${book.getTitle()}</option>
                                                       </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-10">
                                                    <input
                                                            type="submit"
                                                            class="btn btn-primary"
                                                            value="Thêm mới"
                                                    />
                                                    <button
                                                            type="reset"
                                                            class="btn btn-primary"
                                                    >
                                                        Nhập lại
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <!-- End General Form Elements -->
                                <!-- Modal -->

                            </div>
                        </div>
                    </div>
                </c:when>
            </c:choose>
            <%--      Notification      --%>
            <jsp:include page="/WEB-INF/layout/notification.jsp"/>
        </div>
    </section>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="/WEB-INF/layout/footer.jsp"/>

<!-- Vendor JS Files -->
<jsp:include page="/WEB-INF/layout/script.jsp"/>
<jsp:include page="/WEB-INF/layout/toast_trigger.jsp"/>
</body>
</html>
