/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.resume.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 *
 * @author SahilAppayev
 */
@WebServlet(name = "UserController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {
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
            ControllerUtil.errorPage(response, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        if(action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            Integer age = Integer.valueOf(request.getParameter("age"));
            Date birthDate = Date.valueOf(request.getParameter("date"));
            String birthPlaceStr = request.getParameter("place");
            String nationaltyStr = request.getParameter("natinality");
            String phone = request.getParameter("phone");
            String adress = request.getParameter("adress");
            String profileDesc = request.getParameter("profile");

            Country birthPlace = new Country(null, birthPlaceStr, null);
            Country nationality = new Country(null, null, nationaltyStr);

            User user = userDao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAge(age);
            user.setBirthDate(birthDate);
//        user.setBirthPlace(birthPlace);
//        user.setNationality(nationality);
            user.setPhone(phone);
            user.setAdress(adress);
            user.setProfileDescription(profileDesc);

            userDao.update(user);
        } else if(action.equals("delete")){
            userDao.delete(id);
        }
        response.sendRedirect("users");
    }

}
