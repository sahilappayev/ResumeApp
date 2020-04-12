<%-- 
    Document   : user
    Created on : Feb 25, 2020, 10:34:47 PM
    Author     : SahilAppayev
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%--jstl import--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

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

<%--
Include another jsp page in jsp page
<%@include file="login.jsp"%>
<jsp:include page="login.jsp">
--%>

<div class="container my_container">
    <%-- Logged in User--%>
    <%--        <div class="form-row">--%>
    <%--            <div class="form-group" style="margin-right: 0">--%>
    <%--                <h1 style="color: blue"> Welcome <%=user.getName() + " " + user.getSurname() %>!</h1>--%>
    <%--            </div>--%>
    <%--            <div class="form-group" style="margin-right: 15px">--%>
    <%--                <form action="login" method="get">--%>
    <%--                    <input type="submit" name="logout" value="Logout" class="btn btn-secondary form-control">--%>
    <%--                </form>--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <%--Search are--%>
    <div>
        <f:form action="usersm" method="get" modelAttribute="user">
            <div class="form-group col-6">
                <div>
                    <label name="name">Name:</label>
                    <f:input type="text" path="name" placeholder="Enter name" class="form-control"/>
                    <f:errors path="name"></f:errors>
                </div>
                <div>
                    <label name="surname">Surname:</label>
                    <f:input type="text" path="surname" placeholder="Enter surname" class="form-control"/>
                    <f:errors path="surname"></f:errors>
                </div>
                <input type="submit" name="search" value="Search" class="btn btn-primary"/>
            </div>
        </f:form>
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
                <%--jstl code--%>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.name}
                        </td>
                        <td>${u.surname}
                        </td>
                        <td>${u.age}
                        </td>
                        <td style="width: 5px">
                                <%--Delete button--%>
                            <form action="userdetail" method="post">
                                <button type="button" value="Delete" class="btn btn-danger" data-toggle="modal"
                                        data-target="#exampleModal" onclick="setIdForDelete('${u.id}');
                                        setNameForDelete('${u.name}')"><i class="fas fa-trash-alt"> </i></button>
                            </form>
                        </td>
                        <td style="width: 5px">
                                <%--Edit button--%>
                            <form action="userdetail" method="get">
                                <input type="hidden" name="id" value="${u.id}">
                                <button type="submit" value="Edit" class="btn btn-secondary"><i
                                        class="fas fa-user-edit"></i></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
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
