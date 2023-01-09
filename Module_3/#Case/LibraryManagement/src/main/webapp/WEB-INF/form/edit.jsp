<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Forms / Elements - NiceAdmin Bootstrap Template</title>
    <jsp:include page="/WEB-INF/layout/head_link.jsp"></jsp:include>
</head>

<body>
<!-- ======= Header ======= -->
<jsp:include page="/WEB-INF/layout/header.jsp"></jsp:include>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<jsp:include page="/WEB-INF/layout/side_bar.jsp"></jsp:include>
<!-- End Sidebar-->

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Form Elements</h1>
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
            <div class="col-xl-12">
                <div class="card">
                    <c:set var="view" value="${requestScope['view']}"/>
                    <c:choose>
                        <c:when test="${view=='user'}">
                            <c:set var="user" value="${requestScope['user']}"/>
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">
                                    <li class="nav-item">
                                        <button
                                                class="nav-link active"
                                                data-bs-toggle="tab"
                                                data-bs-target="#profile-edit"
                                        >
                                            Edit Profile
                                        </button>
                                    </li>
                                    <li class="nav-item">
                                        <button
                                                class="nav-link"
                                                data-bs-toggle="tab"
                                                data-bs-target="#profile-change-password"
                                        >
                                            Change Password
                                        </button>
                                    </li>
                                </ul>
                                <div class="tab-content pt-2">
                                    <div
                                            class="tab-pane fade profile-edit pt-3 active show"
                                            id="profile-edit"
                                    >
                                        <!-- Profile Edit Form -->
                                        <form method="post" action="${pageContext.request.contextPath}/user?action=edit&id=${user.getId()}">
                                            <div class="row mb-3">
                                                <label
                                                        for="fullName"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Full Name</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="userFullName"
                                                            type="text"
                                                            class="form-control"
                                                            id="fullName"
                                                            value="${user.getFullName()}"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label
                                                        for="Address"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Address</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="userAddress"
                                                            type="text"
                                                            class="form-control"
                                                            id="Address"
                                                            value="${user.getAddress()}"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label
                                                        for="Phone"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Phone</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="userNumber"
                                                            type="text"
                                                            class="form-control"
                                                            id="Phone"
                                                            value="${user.getMobile()}"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label
                                                        for="Email"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Email</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="userEmail"
                                                            type="email"
                                                            class="form-control"
                                                            id="Email"
                                                            value="${user.getEmail()}"
                                                    />
                                                </div>
                                            </div>
                                            <div class="row mb-3 d-none">
                                                <label
                                                        for="dateAdded"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >dateAdded</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="dateAdded"
                                                            type="text"
                                                            class="form-control"
                                                            id="dateAdded"
                                                            value="${user.getCreatedAt()}"
                                                    />
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                > Quyền</div
                                                >
                                                <div class="col-md-8 col-lg-9 d-flex">
                                                    <div class="form-check">
                                                        <input
                                                                required
                                                                class="form-check-input"
                                                                type="radio"
                                                                name="role"
                                                                id="admin"
                                                                value="1"
                                                                checked=""
                                                        />
                                                        <label
                                                                class="fosẵnrm-check-label"
                                                                for="admin"
                                                        >
                                                            Thủ thư
                                                        </label>
                                                    </div>
                                                    <div class="form-check mx-5">
                                                        <input
                                                                required
                                                                class="form-check-input"
                                                                type="radio"
                                                                name="role"
                                                                id="member"
                                                                value="2"
                                                        />
                                                        <label
                                                                class="form-check-label"
                                                                for="member"
                                                        >
                                                            Thành viên
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button
                                                        type="submit"
                                                        class="btn btn-primary"
                                                >
                                                    Save Changes
                                                </button>
                                            </div>
                                        </form>
                                        <!-- End Profile Edit Form -->
                                    </div>

                                    <div
                                            class="tab-pane fade pt-3"
                                            id="profile-change-password"
                                    >
                                        <!-- Change Password Form -->
                                        <form>
                                            <div class="row mb-3">
                                                <label
                                                        for="currentPassword"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Current Password</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="password"
                                                            type="password"
                                                            class="form-control"
                                                            id="currentPassword"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label
                                                        for="newPassword"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >New Password</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="newpassword"
                                                            type="password"
                                                            class="form-control"
                                                            id="newPassword"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label
                                                        for="renewPassword"
                                                        class="col-md-4 col-lg-3 col-form-label"
                                                >Re-enter New
                                                    Password</label
                                                >
                                                <div class="col-md-8 col-lg-9">
                                                    <input
                                                            name="renewpassword"
                                                            type="password"
                                                            class="form-control"
                                                            id="renewPassword"
                                                    />
                                                </div>
                                            </div>

                                            <div class="text-center">
                                                <button
                                                        type="submit"
                                                        class="btn btn-primary"
                                                >
                                                    Change Password
                                                </button>
                                            </div>
                                        </form>
                                        <!-- End Change Password Form -->
                                    </div>
                                </div>
                                <!-- End Bordered Tabs -->
                            </div>
                        </c:when>
                        <c:when test="${view=='book'}">
                            <c:set var="book" value="${requestScope['book']}"/>
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">
                                            Chỉnh sửa thông tin sách
                                        </h5>

                                        <!-- General Form Elements -->
                                        <form method="post" action="${pageContext.request.contextPath}/book?action=edit">
                                            <div class="row mb-3 d-none">
                                                <label
                                                        for="inputId"
                                                        class="col-sm-2 col-form-label"
                                                >ID</label
                                                >
                                                <div class="col-sm-4">
                                                    <input
                                                            required
                                                            id="inputId"
                                                            name="id"
                                                            type="text"
                                                            class="form-control"
                                                            value="${book.getId()}"
                                                    />
                                                </div>
                                                <label
                                                        for="inputIsDeleted"
                                                        class="col-sm-2 col-form-label text-center"
                                                >Đã xoá</label
                                                >
                                                <div class="col-sm-4">
                                                    <input
                                                            required
                                                            name="isDeleted"
                                                            id="inputIsDeleted"
                                                            type="text"
                                                            class="form-control"
                                                            value="${book.isDeleted()}"
                                                    />
                                                </div>
                                                <label
                                                        for="inputDateAded"
                                                        class="col-sm-2 col-form-label text-center"
                                                >Ngày thêm</label
                                                >
                                                <div class="col-sm-4">
                                                    <input
                                                            required
                                                            name="dateAdded"
                                                            id="inputDateAded"
                                                            type="text"
                                                            class="form-control"
                                                            value="${book.getCreatedAt()}"
                                                    />
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label
                                                        for="inputIsbn"
                                                        class="col-sm-2 col-form-label"
                                                >ISBN</label
                                                >
                                                <div class="col-sm-4">
                                                    <input
                                                            required
                                                            id="inputIsbn"
                                                            name="isbn"
                                                            type="text"
                                                            class="form-control"
                                                            value="${book.getIsbn()}"
                                                    />
                                                </div>
                                                <label
                                                        for="inputTitle"
                                                        class="col-sm-2 col-form-label text-center"
                                                >Tiêu đề</label
                                                >
                                                <div class="col-sm-4">
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
                                                                checked
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
                                                    <button
                                                            type="submit"
                                                            class="btn btn-primary"
                                                    >
                                                        Xác nhận
                                                    </button>
                                                    <button
                                                            type="reset"
                                                            class="btn btn-primary"
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
                    </c:choose>
                </div>
            </div>
            <div aria-live="polite" aria-atomic="true" class="position-absolute top-0 end-0">
                <!-- Position it: -->
                <!-- - `.toast-container` for spacing between toasts -->
                <!-- - `top-0` & `end-0` to position the toasts in the upper right corner -->
                <!-- - `.p-3` to prevent the toasts from sticking to the edge of the container  -->
                <div class="toast-container top-0 end-0 p-3">
                    <!-- Then put toasts within -->
                    <c:set value="${requestScope['errors']}" var="errors"/>
                    <c:forEach items="${requestScope['errors'].keySet()}" var="name">
                        <div class="toast text-danger errorToast border-danger" role="alert">
                            <div class="toast-header text-danger justify-content-between">
                                <i class="bi-exclamation-circle-fill" class="rounded mr-2"></i>
                                <strong class="mr-auto">Lỗi ${name.toLowerCase()}</strong>
                                <button class="btn ml-2 mb-1 close" data-bs-dismiss="toast" aria-label="Close">
                                    <span aria-hidden="true" class="btn-outline-light"><i
                                            class="bi-x-circle"></i> </span>
                                </button>
                            </div>
                            <div class="toast-body">
                                    ${errors.get(name)}
                            </div>
                        </div>
                    </c:forEach>
                    <div class="toast successToast text-success border-success" role="alert">
                        <div class="toast-header text-success justify-content-between">
                            <i class="bi-exclamation-circle-fill" class="rounded mr-2"></i>
                            <strong class="mr-auto">Chỉnh sửa thành công</strong>
                            <button class="btn ml-2 mb-1 close" data-bs-dismiss="toast" aria-label="Close">
                                <span aria-hidden="true" class="btn-outline-light"><i class="bi-x-circle"></i> </span>
                            </button>
                        </div>
                        <div class="toast-body">
                            <p>Chỉnh sửa
                                <c:choose>
                                    <c:when test="${view=='user'}"> người dùng</c:when>
                                    <c:when test="${view=='book'}"> sách</c:when>
                                </c:choose>
                                 thành công
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="/WEB-INF/layout/footer.jsp"></jsp:include>
<!-- Vendor JS Files -->
<jsp:include page="/WEB-INF/layout/script.jsp"></jsp:include>
<jsp:include page="/WEB-INF/layout/toast_trigger.jsp"/>
</body>
</html>
