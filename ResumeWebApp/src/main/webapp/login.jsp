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
<body class="div">
<%
    UserDaoInter userDao = Context.instanceUserDao();
    User user = userDao.getById(1);

    String username = request.getParameter("username");
    String password = request.getParameter("password");

%>
<div class="container col-4 login_form" >
    <form action="users.jsp" method="post">
        <div class="form-group">
            <label>Username:</label>
            <input type="text" name="username" placeholder="Enter username" class="form-control" />
        </div>
        <div class="form-group ">
            <label>Password:</label>
            <input type="text" name="password" placeholder="Enter password" class="form-control" />
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Keep me logged in</label>
        </div>
        <div>
            <a href="">Did you forget your password?</a>
            <input type="submit" name="login" value="Login" class="btn btn-primary">
        </div>

    </form>

</div>

</body>
</html>
