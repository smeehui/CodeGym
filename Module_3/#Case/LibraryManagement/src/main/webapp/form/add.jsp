<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Forms / Elements - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description"/>
    <meta content="" name="keywords"/>

    <!-- Favicons -->
    <link href="../assets/img/favicon.png" rel="icon"/>
    <link
            href="../assets/img/apple-touch-icon.png"
            rel="apple-touch-icon"
    />

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect"/>
    <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link
            href="../assets/vendor/bootstrap/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <link
            href="../assets/vendor/bootstrap-icons/bootstrap-icons.css"
            rel="stylesheet"
    />
    <link
            href="../assets/vendor/boxicons/css/boxicons.min.css"
            rel="stylesheet"
    />
    <link href="../assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
    <link href="../assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
    <link
            href="../assets/vendor/remixicon/remixicon.css"
            rel="stylesheet"
    />
    <link
            href="../assets/vendor/simple-datatables/style.css"
            rel="stylesheet"
    />

    <!-- Template Main CSS File -->
    <link href="../assets/css/style.css" rel="stylesheet"/>

    <!-- =======================================================
* Template Name: NiceAdmin - v2.5.0
* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
======================================================== -->
</head>

<body>
<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="../assets/img/logo.png" alt=""/>
            <span class="d-none d-lg-block">NiceAdmin</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>
    <!-- End Logo -->

    <div class="search-bar">
        <form
                class="search-form d-flex align-items-center"
                method="POST"
                action="#"
        >
            <input
                    type="text"
                    name="query"
                    placeholder="Search"
                    title="Enter search keyword"
            />
            <button type="submit" title="Search">
                <i class="bi bi-search"></i>
            </button>
        </form>
    </div>
    <!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle" href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li>
            <!-- End Search Icon-->

            <li class="nav-item dropdown">
                <a
                        class="nav-link nav-icon"
                        href="#"
                        data-bs-toggle="dropdown"
                >
                    <i class="bi bi-bell"></i>
                    <span class="badge bg-primary badge-number"
                    >4</span
                    > </a
                ><!-- End Notification Icon -->

                <ul
                        class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications"
                >
                    <li class="dropdown-header">
                        You have 4 new notifications
                        <a href="#"
                        ><span
                                class="badge rounded-pill bg-primary p-2 ms-2"
                        >View all</span
                        ></a
                        >
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i
                                class="bi bi-exclamation-circle text-warning"
                        ></i>
                        <div>
                            <h4>Lorem Ipsum</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>30 min. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-x-circle text-danger"></i>
                        <div>
                            <h4>Atque rerum nesciunt</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>1 hr. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-check-circle text-success"></i>
                        <div>
                            <h4>Sit rerum fuga</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>2 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-info-circle text-primary"></i>
                        <div>
                            <h4>Dicta reprehenderit</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>4 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>
                    <li class="dropdown-footer">
                        <a href="#">Show all notifications</a>
                    </li>
                </ul>
                <!-- End Notification Dropdown Items -->
            </li>
            <!-- End Notification Nav -->

            <li class="nav-item dropdown">
                <a
                        class="nav-link nav-icon"
                        href="#"
                        data-bs-toggle="dropdown"
                >
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number"
                    >3</span
                    > </a
                ><!-- End Messages Icon -->

                <ul
                        class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages"
                >
                    <li class="dropdown-header">
                        You have 3 new messages
                        <a href="#"
                        ><span
                                class="badge rounded-pill bg-primary p-2 ms-2"
                        >View all</span
                        ></a
                        >
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img
                                    src="../assets/img/messages-1.jpg"
                                    alt=""
                                    class="rounded-circle"
                            />
                            <div>
                                <h4>Maria Hudson</h4>
                                <p>
                                    Velit asperiores et ducimus soluta
                                    repudiandae labore officia est ut...
                                </p>
                                <p>4 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img
                                    src="../assets/img/messages-2.jpg"
                                    alt=""
                                    class="rounded-circle"
                            />
                            <div>
                                <h4>Anna Nelson</h4>
                                <p>
                                    Velit asperiores et ducimus soluta
                                    repudiandae labore officia est ut...
                                </p>
                                <p>6 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img
                                    src="../assets/img/messages-3.jpg"
                                    alt=""
                                    class="rounded-circle"
                            />
                            <div>
                                <h4>David Muldon</h4>
                                <p>
                                    Velit asperiores et ducimus soluta
                                    repudiandae labore officia est ut...
                                </p>
                                <p>8 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">Show all messages</a>
                    </li>
                </ul>
                <!-- End Messages Dropdown Items -->
            </li>
            <!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">
                <a
                        class="nav-link nav-profile d-flex align-items-center pe-0"
                        href="#"
                        data-bs-toggle="dropdown"
                >
                    <img
                            src="../assets/img/profile-img.jpg"
                            alt="Profile"
                            class="rounded-circle"
                    />
                    <span class="d-none d-md-block dropdown-toggle ps-2"
                    >K. Anderson</span
                    > </a
                ><!-- End Profile Iamge Icon -->

                <ul
                        class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile"
                >
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a
                                class="dropdown-item d-flex align-items-center"
                                href="users-profile.html"
                        >
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a
                                class="dropdown-item d-flex align-items-center"
                                href="users-profile.html"
                        >
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a
                                class="dropdown-item d-flex align-items-center"
                                href="pages-faq.html"
                        >
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a
                                class="dropdown-item d-flex align-items-center"
                                href="#"
                        >
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>
                </ul>
                <!-- End Profile Dropdown Items -->
            </li>
            <!-- End Profile Nav -->
        </ul>
    </nav>
    <!-- End Icons Navigation -->
</header>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.html">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <!-- End Dashboard Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#components-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-menu-button-wide"></i
                ><span>Quản lý thành viên</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="components-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="./user/add.html">
                        <i class="bi bi-circle"></i
                        ><span>Thêm mới</span>
                    </a>
                </li>
                <li>
                    <a href="components-pagination.html">
                        <i class="bi bi-circle"></i
                        ><span>Xem danh sách</span>
                    </a>
                </li>
                <li>
                    <a href="components-progress.html">
                        <i class="bi bi-circle"></i
                        ><span>Lịch sử chỉnh sửa</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Components Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#forms-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-journal-text"></i
                ><span>Quản lý sách</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="forms-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="forms-elements.html">
                        <i class="bi bi-circle"></i
                        ><span>Thêm mới</span>
                    </a>
                </li>
                <li>
                    <a href="forms-layouts.html">
                        <i class="bi bi-circle"></i
                        ><span>Xem danh sách</span>
                    </a>
                </li>
                <li>
                    <a href="forms-editors.html">
                        <i class="bi bi-circle"></i
                        ><span>Lịch sử chình sửa</span>
                    </a>
                </li>
                <li>
                    <a href="forms-validation.html">
                        <i class="bi bi-circle"></i
                        ><span>Form Validation</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Forms Nav -->
        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#book-items"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-journal-text"></i
                ><span>Quản lý mượn sách</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="book-items"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="forms-elements.html">
                        <i class="bi bi-circle"></i
                        ><span>Thêm mới</span>
                    </a>
                </li>
                <li>
                    <a href="forms-layouts.html">
                        <i class="bi bi-circle"></i
                        ><span>Xem danh sách</span>
                    </a>
                </li>
                <li>
                    <a href="forms-editors.html">
                        <i class="bi bi-circle"></i
                        ><span>Lịch sử chình sửa</span>
                    </a>
                </li>
                <li>
                    <a href="forms-validation.html">
                        <i class="bi bi-circle"></i
                        ><span>Form Validation</span>
                    </a>
                </li>
            </ul>
        </li>

        <!-- End Tables Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#charts-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-bar-chart"></i><span>Charts</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="charts-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="charts-chartjs.html">
                        <i class="bi bi-circle"></i
                        ><span>Chart.js</span>
                    </a>
                </li>
                <li>
                    <a href="charts-apexcharts.html">
                        <i class="bi bi-circle"></i
                        ><span>ApexCharts</span>
                    </a>
                </li>
                <li>
                    <a href="charts-echarts.html">
                        <i class="bi bi-circle"></i><span>ECharts</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Charts Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#icons-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-gem"></i><span>Icons</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="icons-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="icons-bootstrap.html">
                        <i class="bi bi-circle"></i
                        ><span>Bootstrap Icons</span>
                    </a>
                </li>
                <li>
                    <a href="icons-remix.html">
                        <i class="bi bi-circle"></i
                        ><span>Remix Icons</span>
                    </a>
                </li>
                <li>
                    <a href="icons-boxicons.html">
                        <i class="bi bi-circle"></i
                        ><span>Boxicons</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Icons Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>F.A.Q</span>
            </a>
        </li>
        <!-- End F.A.Q Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-contact.html">
                <i class="bi bi-envelope"></i>
                <span>Contact</span>
            </a>
        </li>
        <!-- End Contact Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li>
        <!-- End Register Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li>
        <!-- End Login Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-error-404.html">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li>
        <!-- End Error 404 Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-blank.html">
                <i class="bi bi-file-earmark"></i>
                <span>Blank</span>
            </a>
        </li>
        <!-- End Blank Page Nav -->
    </ul>
</aside>
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
            <c:if test="${requestScope.get('view')=='user'}">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">
                                Thêm thành viên
                            </h5>

                            <!-- General Form Elements -->
                            <form>
                                <div class="row mb-3">
                                    <label
                                            class="col-sm-2 col-form-label"
                                            for="inputName"
                                    >Tên đầy đủ</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                id="inputName"
                                                class="form-control"
                                                type="text"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            class="col-sm-2 col-form-label"
                                            for="inputText"
                                    >Username</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                class="form-control"
                                                type="text"
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
                                        <input
                                                class="form-control"
                                                type="password"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            class="col-sm-2 col-form-label"
                                            for="inputAddress"
                                    >Địa chỉ</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                id="inputAddress"
                                                class="form-control"
                                                type="text"
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
                                        <input
                                                class="form-control"
                                                type="email"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            class="col-sm-2 col-form-label"
                                            for="inputNumber"
                                    >Phone number</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                class="form-control"
                                                type="number"
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
                                            <input
                                                    checked
                                                    class="form-check-input"
                                                    id="gridRadios1"
                                                    name="gridRadios"
                                                    type="radio"
                                                    value="option1"
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridRadios1"
                                            >
                                                Thành viên
                                            </label>
                                        </div>
                                        <div class="form-check d-inline-block">
                                            <input
                                                    class="form-check-input"
                                                    id="gridRadios2"
                                                    name="gridRadios"
                                                    type="radio"
                                                    value="option2"
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridRadios2"
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
            </c:if>
            <c:if test="${requestScope.get('view')=='book'}">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">
                                General Form Elements
                            </h5>

                            <!-- General Form Elements -->
                            <form>
                                <div class="row mb-3">
                                    <label
                                            for="inputText"
                                            class="col-sm-2 col-form-label"
                                    >Text</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="text"
                                                class="form-control"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputEmail"
                                            class="col-sm-2 col-form-label"
                                    >Tên sách</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="email"
                                                class="form-control"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputPassword"
                                            class="col-sm-2 col-form-label"
                                    >Mã ISBN</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="password"
                                                class="form-control"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputNumber"
                                            class="col-sm-2 col-form-label"
                                    >Number</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="number"
                                                class="form-control"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputNumber"
                                            class="col-sm-2 col-form-label"
                                    >File Upload</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                class="form-control"
                                                type="file"
                                                id="formFile"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputDate"
                                            class="col-sm-2 col-form-label"
                                    >Date</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="date"
                                                class="form-control"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputTime"
                                            class="col-sm-2 col-form-label"
                                    >Time</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="time"
                                                class="form-control"
                                        />
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label
                                            for="inputColor"
                                            class="col-sm-2 col-form-label"
                                    >Color Picker</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="color"
                                                class="form-control form-control-color"
                                                id="exampleColorInput"
                                                value="#4154f1"
                                                title="Choose your color"
                                        />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label
                                            for="inputPassword"
                                            class="col-sm-2 col-form-label"
                                    >Textarea</label
                                    >
                                    <div class="col-sm-10">
                                            <textarea
                                                    class="form-control"
                                                    style="height: 100px"
                                            ></textarea>
                                    </div>
                                </div>
                                <fieldset class="row mb-3">
                                    <legend
                                            class="col-form-label col-sm-2 pt-0"
                                    >
                                        Radios
                                    </legend>
                                    <div class="col-sm-10">
                                        <div class="form-check">
                                            <input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gridRadios"
                                                    id="gridRadios1"
                                                    value="option1"
                                                    checked
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridRadios1"
                                            >
                                                First radio
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gridRadios"
                                                    id="gridRadios2"
                                                    value="option2"
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridRadios2"
                                            >
                                                Second radio
                                            </label>
                                        </div>
                                        <div class="form-check disabled">
                                            <input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gridRadios"
                                                    id="gridRadios"
                                                    value="option"
                                                    disabled
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridRadios3"
                                            >
                                                Third disabled radio
                                            </label>
                                        </div>
                                    </div>
                                </fieldset>
                                <div class="row mb-3">
                                    <legend
                                            class="col-form-label col-sm-2 pt-0"
                                    >
                                        Checkboxes
                                    </legend>
                                    <div class="col-sm-10">
                                        <div class="form-check">
                                            <input
                                                    class="form-check-input"
                                                    type="checkbox"
                                                    id="gridCheck1"
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridCheck1"
                                            >
                                                Example checkbox
                                            </label>
                                        </div>

                                        <div class="form-check">
                                            <input
                                                    class="form-check-input"
                                                    type="checkbox"
                                                    id="gridCheck2"
                                                    checked
                                            />
                                            <label
                                                    class="form-check-label"
                                                    for="gridCheck2"
                                            >
                                                Example checkbox 2
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label"
                                    >Disabled</label
                                    >
                                    <div class="col-sm-10">
                                        <input
                                                type="text"
                                                class="form-control"
                                                value="Read only / Disabled"
                                                disabled
                                        />
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label"
                                    >Select</label
                                    >
                                    <div class="col-sm-10">
                                        <select
                                                class="form-select"
                                                aria-label="Default select example"
                                        >
                                            <option selected>
                                                Open this select menu
                                            </option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label"
                                    >Multi Select</label
                                    >
                                    <div class="col-sm-10">
                                        <select
                                                class="form-select"
                                                multiple
                                                aria-label="multiple select example"
                                        >
                                            <option selected>
                                                Open this select menu
                                            </option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label"
                                    >Submit Button</label
                                    >
                                    <div class="col-sm-10">
                                        <button
                                                type="submit"
                                                class="btn btn-primary"
                                        >
                                            Submit Form
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <!-- End General Form Elements -->
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </section>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong
    >. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by
        <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer>
<!-- End Footer -->

<a
        href="#"
        class="back-to-top d-flex align-items-center justify-content-center"
><i class="bi bi-arrow-up-short"></i
></a>

<!-- Vendor JS Files -->
<script src="../assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../assets/vendor/chart.js/chart.umd.js"></script>
<script src="../assets/vendor/echarts/echarts.min.js"></script>
<script src="../assets/vendor/quill/quill.min.js"></script>
<script src="../assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="../assets/vendor/tinymce/tinymce.min.js"></script>
<script src="../assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="../assets/js/main.js"></script>
</body>
</html>
