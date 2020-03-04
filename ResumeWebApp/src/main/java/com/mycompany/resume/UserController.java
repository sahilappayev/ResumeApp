/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SahilAppayev
 */
@WebServlet(name = "UserController", urlPatterns = {"/userdetail"})
public class UserController extends HttpServlet {
    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            if (idStr == null || idStr.trim().isEmpty()) {
                throw new IllegalArgumentException("ID is not defined!");
            }

            Integer id = Integer.valueOf(idStr);
            User u = userDao.getById(id);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id!");
            }

            request.setAttribute("User", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request,response);
        }catch (Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error.jsp?msg="+ex.getMessage());
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer age  = Integer.valueOf(request.getParameter("age"));
        Date birthDate = Date.valueOf(request.getParameter("date"));
        request.getParameter("place");
        request.getParameter("natinality");
        request.getParameter("phone");
        request.getParameter("adress");
        request.getParameter("profile");

        User user = userDao.getById(id);


        user.setName(name);
        user.setSurname(surname);

        userDao.update(user);
        response.sendRedirect("userdetail.jsp");
    }



}
