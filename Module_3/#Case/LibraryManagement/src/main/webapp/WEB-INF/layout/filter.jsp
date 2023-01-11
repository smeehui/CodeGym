<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
  <div class="dropdown">
    <button class="btn btn-sm btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
            data-bs-toggle="dropdown" aria-expanded="false">
      <c:choose>
        <c:when test="${param['deleted']==true}">Đã xóa</c:when>
        <c:when test="${param['deleted']==false}">Đang hoạt động</c:when>
        <c:when test="${param['deleted']==null}">Tất cả</c:when>
      </c:choose>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
      <li><a class="dropdown-item" href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%>">Tất cả</a></li>
      <li><a class="dropdown-item" href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%>&deleted=false">Đang hoạt động</a></li>
      <li><a class="dropdown-item" href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%>&deleted=true">Đã xóa</a></li>
    </ul>
  </div>
</div>