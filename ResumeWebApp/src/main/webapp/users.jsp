<%-- 
    Document   : user
    Created on : Feb 25, 2020, 10:34:47 PM
    Author     : SahilAppayev
--%>

<%@page import="com.mycompany.entity.User" %>
<%@page import="com.mycompany.main.Context" %>
<%@page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All Users</title>

    <link rel="stylesheet" href="assets/css/users.css"/>
    <script src="assets/js/users.js"></script>
    <script src="https://kit.fontawesome.com/6770b2fa5e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body class="users_bg">

<%
    User user = (User) request.getSession().getAttribute("user"); //LoggedInUser

    List<User> users = (List<User>) request.getAttribute("users");//AllUsers
%>

<div class="container my_container">
    <%-- Logged in User--%>
    <center><h1 style="color: blue"> Welcome <%=user.getName()%>!</h1></center>

    <%--Search are--%>
    <div>
        <form action="users" method="get">
            <div class="form-group col-6">
                <div>
                    <label name="name">Name:</label>
                    <input type="text" name="name" value="" placeholder="Enter name" class="form-control"/>
                </div>
                <div>
                    <label name="surname">Surname:</label>
                    <input type="text" name="surname" value="" placeholder="Enter surname" class="form-control"/>
                </div>
                <input type="submit" name="search" value="Search" class="btn btn-primary"/>
            </div>
        </form>
    </div>
    <br>
    <%--Table content are--%>
    <div>
        <form>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (User u : users) {
                %>
                <tr>
                    <td><%=u.getName()%>
                    </td>
                    <td><%=u.getSurname()%>
                    </td>
                    <td><%=u.getAge()%>
                    </td>
                    <td style="width: 5px">
                        <%--Delete button--%>
                        <button type="button" value="Delete" class="btn btn-danger" data-toggle="modal"
                                data-target="#exampleModal" onclick="setIdForDelete('<%=u.getId()%>');
                                setNameForDelete('<%=u.getName()%>')"><i class="fas fa-trash-alt"> </i></button>
                    </td>
                    <td style="width: 5px">
                        <%--Edit button--%>
                        <form action="userdetail" method="get">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                            <button type="submit" value="Edit" class="btn btn-secondary"><i
                                    class="fas fa-user-edit"></i></button>
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </form>
    </div>

</div>

<!-- Delete Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%--Span tagine id istifade etmekle js funksiyasi ile html deyer oturulur--%>
                <h3>Are you sure to delete <span id="nameForDelete"></span>?</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                <form action="userdetail" method="post">
                    <%--id inputuna "idForDelete" id`sinden istifade etmekle js funksiyasi ile yuxaridaki delete duymesini click`leyende id deyeri oturulur--%>
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>

</div>

</body>
</html>
