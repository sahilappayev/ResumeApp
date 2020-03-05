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
    <script src="https://kit.fontawesome.com/6770b2fa5e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="users_bg">

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<div class="container my_container">
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
                        <form action="userdetail" method="post">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit" value="Delete" class="btn btn-danger"><i
                                    class="fas fa-trash-alt"></i></button>
                        </form>
                    </td>
                    <td style="width: 5px">
                        <form action="userdetail" method="get">
                            <input type="hidden" name="id" value="<%=u.getId()%>">
                            <input type="hidden" name="action" value="update">
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
</body>
</html>
