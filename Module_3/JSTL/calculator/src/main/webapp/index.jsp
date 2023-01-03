<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        form>fieldset{
            display: flex;
            flex-direction: column;
            width:fit-content;
        }
        .input{
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
        label{
            width: 50%;
        }
        .input select,.input input{
            width: 200px;
        }
        .result{
            width: 100%;
            border: 1px solid #ccc;
            color: green;
            height: 30px;
            margin-top: 20px;
            display: flex;
            align-items: center;
            font-size: 2rem;
        }
        .result>p{
            width: 100%;
            text-align: right;
        }
    </style>
</head>
<body>
    <h1>Calculator</h1>
    <form action="/calculate" method="post">
        <fieldset>
            <legend>Calculator</legend>
            <div class="input">
                <label for="first-operand">First operand</label>
                <input id="first-operand" type="number" placeholder="Enter number..." name="fOperand">
            </div>
            <div class="input">
                <label >Operator</label>
                <select name="operator">
                    <option value="add">Addition</option>
                    <option value="min">Minor</option>
                    <option value="div">Division</option>
                    <option value="mul">Multiplication</option>
                </select>
            </div>
            <div class="input">
                <label for="scnd-operand">second operand</label>
                <input id="scnd-operand" type="number" placeholder="Enter number..." name="sOperand">
            </div>
            <input type="submit" value="Calculate">
            <div class="result">
                <p >
                    <c:out value="${requestScope.get('result')!='Infinity'?requestScope.get('result'):'Cannot divide by zero'}"/>
                </p>
            </div>
        </fieldset>
    </form>

</body>
</html>