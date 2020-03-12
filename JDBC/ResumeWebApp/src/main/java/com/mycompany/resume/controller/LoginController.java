/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.resume.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author SahilAppayev
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    UserDaoInter userDao = Context.instanceUserDao();
    BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logout = request.getParameter("logout");
        if("Logout".equals(logout)){
            request.getSession().invalidate();
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User u = userDao.getByEmail(email);
            if (u == null) {
//                request.setAttribute("msg", "User doesn`t exist!");
//                response.sendRedirect("login");
                throw new IllegalArgumentException("User doesn`t exist!");
            }
            System.out.println(u.getName());
            BCrypt.Result rs = verifyer.verify(password.toCharArray(), u.getPassword().toCharArray());
            System.out.println(rs.verified);
            if (!rs.verified) {
//                request.setAttribute("msg", "Password is incorrect!");
//                response.sendRedirect("login");
                throw new IllegalArgumentException("Password is incorrect!");
            }else {
                request.getSession().setAttribute("loggedInUser", u);
                response.sendRedirect("users");
            }
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }

}
