<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.03.2020
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>What is wrong?</title>
</head>
<body>
<%
    String msg = request.getParameter("msg");
%>
<%=msg%>
</body>
</html>
