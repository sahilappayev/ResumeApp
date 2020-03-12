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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div style="margin: 50px auto; width: 600px; height: 600px">
    <img src="assets/images/error.png">
    <center><h1><%=request.getParameter("msg")%></h1></center>
</div>

</body>
</html>
