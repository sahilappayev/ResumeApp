<%@ page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="assets/css/users.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="login_bg">
<%

%>
<div class="container my_container col-4 login_form" >
    <center><h1 style="color: blue">Login</h1></center>
    <form action="login" method="get">
        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" placeholder="Enter email: user@example.com" class="form-control" />
        </div>
        <div class="form-group ">
            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter password" class="form-control" />
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Keep me logged in</label>
        </div>
        <div style="margin-right: 5px ; width: 300px">
            <a href="">Did you forget your password?</a>
            <input type="submit" name="login" value="Login" class="btn btn-primary">
        </div>

    </form>

</div>

</body>
</html>
