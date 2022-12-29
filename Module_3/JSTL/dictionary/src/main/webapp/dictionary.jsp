<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%! Map<String, String> dict = new HashMap<>();%>
<%
    dict.put("hello", "Xin chào");
    dict.put("how", "Thế nào");
    dict.put("book", "Quyển vở");
    dict.put("computer", "Máy tính");

    String search = request.getParameter("search");

    String result = dict.get(search);
    if (result != null) {
        out.println("Word: " + search);
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>
</body>
</html>