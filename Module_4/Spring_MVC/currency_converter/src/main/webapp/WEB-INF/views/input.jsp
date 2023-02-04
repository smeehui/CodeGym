<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 30/01/2023
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<fieldset>
    <legend>Currency Converter</legend>
    <form action="convert" method="post">
        <div>
            <label for="inputType">Type:</label>
            <select id="inputType" name="type">
                <option>---Select currencies---</option>
                <option value="v2u">VND to USD</option>
                <option value="u2v">USD to VND</option>
            </select>
        </div>
        <div>
            <label for="inputAmount">Amount:</label>
            <input type="number" step="any" id="inputAmount" placeholder="Enter amount" name="amount">
        </div>
        <div>
            <label for="inputRate">Rate of exchange:</label>
            <input type="number" id="inputRate" placeholder="Enter rate" name="rate">
        </div>
        <input type="submit" value="Convert">
    </form>
</fieldset>
</body>
</html>
