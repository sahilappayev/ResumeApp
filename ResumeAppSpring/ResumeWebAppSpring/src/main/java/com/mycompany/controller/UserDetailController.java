package com.mycompany.controller;


import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    UserServiceInter userService;

    @RequestMapping(method = {RequestMethod.GET}, value = "/userdetail")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        try {
            String idStr = request.getParameter("id");
            if (idStr == null || idStr.trim().isEmpty()) {
                throw new IllegalArgumentException("ID is not defined!");
            }
            Integer id = Integer.valueOf(idStr);
            User u = userService.getById(id);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id!");
            }
            request.setAttribute("User", u);
        }catch (Exception ex){
            ControllerUtil.errorPage(response, ex);
        }
        return "userdetail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userdetail")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        if (action.equals("update")) {
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

            User user = userService.getById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAge(age);
            user.setBirthDate(birthDate);
//        user.setBirthPlace(birthPlace);
//        user.setNationality(nationality);
            user.setPhone(phone);
            user.setAdress(adress);
            user.setProfileDescription(profileDesc);

            userService.update(user);
        } else if (action.equals("delete")) {
            userService.delete(id);
        }
        response.sendRedirect("users");
    }
}
