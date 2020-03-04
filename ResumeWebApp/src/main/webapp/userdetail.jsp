<%-- 
    Document   : user
    Created on : Feb 25, 2020, 10:34:47 PM
    Author     : SahilAppayev
--%>

<%@page import="com.mycompany.entity.User" %>
<%@page import="com.mycompany.main.Context" %>
<%@page import="com.mycompany.dao.inter.UserDaoInter" %>
<%@ page import="com.mycompany.resume.UserRequestUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Details</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<%
    User u = (User) request.getAttribute("User");

%>


<div class="container my_container">
    <form action="UserController" method="POST">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label> Name:</label>
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <input type="text" name="name" value="<%=u.getName()%>" class="form-control"/>
            </div>
            <div class="form-group col-md-4">
                <label> Surname:</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label>Age:</label>
                <input type="text" name="age" value="<%=u.getAge()%>" class="form-control">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Birth date:</label>
                <input type="date" name="date" value="<%=u.getBirthDate()%>" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label>Birth place:</label>
                <input type="text" name="place" value="<%=u.getBirthPlace().getCountryName()%>" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label>Nationality:</label>
                <input type="text" name="nationalty" value="<%=u.getNatioanality().getNationality()%>"
                       class="form-control">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <label>Profile description:</label>
                <textarea name="profile" class="form-control"> <%=u.getProfileDescription()%>
                </textarea>
            </div>
            <div class="form-group col-md-6">
                <label>Phone:</label>
                <input type="tel" name="phone" value="<%=u.getPhone()%>" class="form-control">
            </div>
            <div class="form-group col-6">
                <label>Adress:</label>
                <input type="text" name="adress" value="<%=u.getAdress()%>" class="form-control">
            </div>

            <div>
                <input type="submit" name="save" value="Save" class="btn btn-primary"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
