<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="assets/css/users.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="login_bg">
<%
    String msg = (String) request.getAttribute("msg");
    System.out.println(msg);
%>
<div class="container my_container col-4 login_form" >
    <center><h1 style="color: blue">Login</h1></center>

    <input type="hidden" value="<%=msg%>" data-toggle="modal" id="messageInput" data-target="#messageModal">

    <form action="login" method="post">
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

<!-- Message Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <%--Span tagine id istifade etmekle js funksiyasi ile html deyer oturulur--%>
                <h3><span id="loginMessage" style="color: red"><%=msg%></span></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
