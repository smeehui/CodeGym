<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function showErrorToast() {
        let options = {
            animation: true,
            delay: 3000
        }
        document.querySelectorAll(".errorToast").forEach((e) => {
            let toast = new bootstrap.Toast(e,options);
            toast.show();
        })
    }

    function showSuccessToast() {
        let options = {
            animation: true,
            delay: 3000
        }
        let toast = new bootstrap.Toast(document.querySelector(".successToast"),options);
        toast.show();
    }

</script>
<script>
    window.onload = function () {
        <c:if test="${!(requestScope['errors'].values().isEmpty())}">
            showErrorToast()
        </c:if>
        <c:if test="${requestScope['success']}">
            showSuccessToast()
        </c:if>
    }

</script>