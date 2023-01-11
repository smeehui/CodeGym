<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav aria-label="Page navigation example" class="d-flex justify-content-end">
    <ul class="pagination pagination-sm align-self-end">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">«</span>
            </a>
        </li>
        <c:forEach begin="1" end="${requestScope['noOfPages']}" var="i">
            <li class="page-item">
                <a class="page-link"
                   href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%>&page=${i}&size=${requestScope['elPerPage']}"
                >
                        ${i}
                </a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">»</span>
            </a>
        </li>
    </ul>
</nav>