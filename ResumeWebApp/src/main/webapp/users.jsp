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
    <title>JSP Page</title>
    <link rel="stylesheet" href="assets/css/users.css"/>
    <script src="https://kit.fontawesome.com/6770b2fa5e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="div">
<%
    UserDaoInter userDao = Context.instanceUserDao();

    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String ageStr = request.getParameter("age");
    Integer age = null;
    if (ageStr != null) {
        age = Integer.parseInt(ageStr);
    }
    List<User> users = userDao.getAll(name, surname, age);

%>
<div class="container">
    <div class="form-group col-6 my_form">
        <form action="users.jsp" method="POST">
            <div>
                <label name="name">Name:</label>
                <input type="text" name="name" value="" placeholder="Enter name" class="form-control"/>
            </div>
            <div>
                <label name="surname">Surname:</label>
                <input type="text" name="surname" value="" placeholder="Enter surname" class="form-control"/>
            </div>
            <input type="submit" name="search" value="Search" class="btn btn-primary"/>
        </form>
    </div>
    <div>
        <form>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
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
                    <td>
                        <button type="submit" name="delet" value="Delete" class="btn btn-danger"><i
                                class="fas fa-trash-alt"></i></button>
                        <button type="submit" name="edit" value="Edit" class="btn btn-secondary"><i
                                class="fas fa-user-edit"></i></button>
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
