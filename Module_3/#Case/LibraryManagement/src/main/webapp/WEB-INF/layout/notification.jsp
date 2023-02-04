<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 15/01/2023
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div aria-live="polite" aria-atomic="true" class="position-absolute top-0 end-0">
    <!-- Position it: -->
    <!-- - `.toast-container` for spacing between toasts -->
    <!-- - `top-0` & `end-0` to position the toasts in the upper right corner -->
    <!-- - `.p-3` to prevent the toasts from sticking to the edge of the container  -->
    <div class="toast-container top-0 end-0 p-3">
        <!-- Then put toasts within -->
        <c:set value="${requestScope['errors']}" var="errors"/>
        <c:forEach items="${requestScope['errors'].keySet()}" var="name">
            <div class="toast text-danger errorToast" role="alert">
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
        <div class="toast successToast text-success" role="alert">
            <c:set var="action" value="${param['action']}"/>
            <div class="toast-header text-success justify-content-between">
                <i class="bi-exclamation-circle-fill" class="rounded mr-2"></i>
                <strong class="mr-auto"><c:choose>
                    <c:when test="${action.equals('add')}">
                        Thêm
                    </c:when>
                    <c:when test="${action.equals('edit')}">Sửa</c:when>
                </c:choose> thành công</strong>
                <button class="btn ml-2 mb-1 close" data-bs-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true" class="btn-outline-light"><i class="bi-x-circle"></i> </span>
                </button>
            </div>
            <div class="toast-body">
                <c:choose>
                    <c:when test="${action.equals('add')}">
                        <p>Thêm
                            <c:choose>
                                <c:when test="${view=='user'}"> người dùng</c:when>
                                <c:when test="${view=='book'}"> sách</c:when>
                            </c:choose>
                            mới thành công
                        </p>
                    </c:when>
                    <c:when test="${action.equals('edit')}">
                        <p>Chỉnh sửa
                            <c:choose>
                                <c:when test="${view=='user'}"> người dùng</c:when>
                                <c:when test="${view=='book'}"> sách</c:when>
                                <c:when test="${view=='bookItem'}"> sách</c:when>
                            </c:choose>
                            thành công
                        </p>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>
