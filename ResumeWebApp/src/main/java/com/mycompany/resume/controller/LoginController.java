/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.resume.config.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author SahilAppayev
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    UserDaoInter userDao = Context.instanceUserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User u = userDao.getByEmailAndPassword(email,password);

        if(u == null){
//            Config config = Config.createConfig();
            request.setAttribute("msg","Email or password incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }else{
            request.getSession().setAttribute("user", u);
            response.sendRedirect("users");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
