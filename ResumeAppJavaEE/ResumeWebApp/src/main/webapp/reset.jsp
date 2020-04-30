<%--
  Created by IntelliJ IDEA.
  User: SahilAppayev
  Date: 10.03.2020
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
    <link rel="stylesheet" href="assets/css/users.css" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="reset_bg">

<div class="container my_container col-4 login_form">
    <form action="reset" method="post">
        <center><h1 style="color: blue">Reset Password</h1></center>
        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" placeholder="Enter email: user@example.com" class="form-control"/>
        </div>
        <div>
            <input type="submit" name="submit" value="Submit" class="btn btn-primary">
        </div>
    </form>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Set new password</h5>
            </div>
            <div class="modal-body">
                <form action="reset" method="post">
                    <div class="form-group ">
                        <label>New password:</label>
                        <input type="password" name="password" placeholder="Enter new password" class="form-control"/>
                    </div>
                    <div class="form-group ">
                        <label>Confirm new password:</label>
                        <input type="password" name="password" placeholder="Enter new password again"
                               class="form-control"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                <form action="reset" method="post">
                    <%--id inputuna "idForDelete" id`sinden istifade etmekle js funksiyasi ile yuxaridaki submit duymesini click`leyende id deyeri oturulur--%>
                    <input type="hidden" name="id" value="" id="idForReset">
                    <input type="hidden" name="action" value="reset">
                    <button type="submit" class="btn btn-danger">Reset</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
