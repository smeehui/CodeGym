<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        form{
            display: flex;
            flex-direction: column;
            padding: 5px;
            width: fit-content;
            background-color: #ccc;
            border-radius: 10px;
        }
        label{
            margin-bottom: 10px;
        }
        input{
            height: 20px;
        }
    </style>
</head>
<body>
    <form action="converter.jsp" method="post">
        <label for="rate">
            Rate:
            <br>
            <input id="rate" type="text" name="rate" placeholder="Enter rate...">
        </label>
        <br>
        <label for="usd">
            USD:
            <br>
            <input id="usd" type="text" name="usd" placeholder="Enter amount...">
        </label>
        <input type="submit">
    </form>
</body>
</html>