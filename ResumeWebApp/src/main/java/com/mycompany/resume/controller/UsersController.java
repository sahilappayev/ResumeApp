/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author SahilAppayev
 */
@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {
    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String ageStr = request.getParameter("age");
        Integer age = null;
        if (ageStr != null) {
            age = Integer.parseInt(ageStr);
        }

        List<User> users = userDao.getAll(name, surname, age);
        request.setAttribute("users", users);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

}
