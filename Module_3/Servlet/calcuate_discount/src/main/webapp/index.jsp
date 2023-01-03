<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        form{
            display: flex;
            width: fit-content;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }
        input{
            margin-bottom: 10px;
            height: 25px;
            width: 150px;
            background-color: transparent;
            border-radius: 5px;
            outline: none;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/calculate" method="post">
        <label>
            <input type="text" name="desc" placeholder="Enter product name...">
        </label>
        <label>
            <input type="number" name="price" placeholder="Enter price...">
        </label>
        <label>
            <input type="number" name="discountPercent" placeholder="Enter discount percent...">
        </label>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>