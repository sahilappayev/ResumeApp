<%-- 
    Document   : user
    Created on : Feb 25, 2020, 10:34:47 PM
    Author     : SahilAppayev
--%>

<%@page import="com.mycompany.entity.User"%>
<%@page import="com.mycompany.main.Context"%>
<%@page import="com.mycompany.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(1);
        %>

        <div>
            <form action="UserController" method="POST" >
                <input type="hidden" name="id" value="<%= u.getId()%>"/>
                <label name="name">Name:</label>
                <input type="text" name="name" value="<%= u.getName()%>" /><br/>
                <label name="surname">Surname:</label>
                <input type="text" name="surname" value="<%= u.getSurname()%>" />
                <input type="submit" name="save" value="Save" />
            </form>
        </div>


    </body>
</html>
