<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Converter</title>
    <style>
        form{
            display: flex;
            flex-direction: column;
            width: fit-content;
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 10px;
            align-items: flex-start;
        }
        input{
            height: 30px;
            margin-bottom: 10px;
            width: 200px;
        }
    </style>
</head>
<body>
    <form action="/convert" method="post">
        <input type="text" placeholder="Enter rate..." name="rate">
        <label for="usd">USD</label>
        <input type="number" placeholder="Enter USD..." name="usd" id="usd">
        <input type="submit" value="Submit">
    </form>
</body>
</html>