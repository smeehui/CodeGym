<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 15/01/2023
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        let bItemPrice = row.querySelector(".bItemPrice").innerText.replace("VND","").replace(",","").trim()
        let bItemNoOfPage = row.querySelector(".bItemNoOfPage").innerText
        let bItemQuantity = row.querySelector(".bItemQuantity").innerText
        let bItemAvailable = row.querySelector(".bItemAvailable").dataset.bitemavailable
        let bItemDayAdded = row.querySelector(".bItemDayAdded").dataset.dateadded
        let bItemPublishedDate = row.querySelector(".bItemPublishedDate").innerText
        let bookId = row.querySelector(".bookId").innerText
        console.log(bItemPrice)
        document.getElementById("inputPublisher").value = bItemPublisher
        document.getElementById("inputDayPublished").value =bItemPublishedDate
        document.getElementById("inputPage").value = bItemNoOfPage
        document.getElementById("inputPrice").value = bItemPrice
        document.getElementById("inputFormat").value = bItemFormat
        document.getElementById("inputQuantity").value =bItemQuantity
        document.getElementById("bItemBookId").value = bookId
        document.getElementById("bItemForm").setAttribute("action",location.protocol + '//' + location.host + location.pathname+"?action=edit&id="+bItemId)
    }



</script>