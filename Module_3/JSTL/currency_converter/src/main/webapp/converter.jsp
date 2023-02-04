<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 29/12/2022
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));

    float vnd = rate * usd;
%>
<h1>Rate: <%=rate%>
</h1>
<h1>USD: <%=usd%>
</h1>
<h1> <%=vnd%>
</body>
</html>
