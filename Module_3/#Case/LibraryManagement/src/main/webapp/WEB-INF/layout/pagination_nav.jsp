<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${requestScope['noOfPages']!=1}">
    <nav aria-label="Page navigation example" class="d-flex justify-content-end position-absolute"
         style="top: 5px;right: 20px">
        <ul class="pagination pagination-sm align-self-end">
            <c:set var="page" value="${requestScope['page']}"/>
            <li class="page-item" <c:if test="${page==1}">hidden</c:if>>
                <a class="page-link"
                   href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%><%=request.getParameter("deleted")!=null?"&deleted="+request.getParameter("deleted"):""%>&page=${page-1}&size=${requestScope['size']}"
                   aria-label="Previous">
                    <span aria-hidden="true">«</span>
                </a>
            </li>
            <c:forEach begin="1" end="${requestScope['noOfPages']}" var="i">
                <li class="page-item <c:if test="${page==i}">active</c:if>">
                    <a class="page-link"
                       href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%><%=request.getParameter("deleted")!=null?"&deleted="+request.getParameter("deleted"):""%>&page=${i}&size=${requestScope['size']}"

                    >
                            ${i}
                    </a>
                </li>
            </c:forEach>
            <li class="page-item" <c:if test="${page==requestScope['noOfPages']}">hidden</c:if>>
                <a class="page-link"
                   href="/${requestScope['view']}?action=${param.action}<%=request.getParameter("q")!=null?"&q="+request.getParameter("q"):""%><%=request.getParameter("deleted")!=null?"&deleted="+request.getParameter("deleted"):""%>&page=${page+1}&size=${requestScope['size']}"
                   aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </li>
        </ul>
    </nav>
</c:if>
