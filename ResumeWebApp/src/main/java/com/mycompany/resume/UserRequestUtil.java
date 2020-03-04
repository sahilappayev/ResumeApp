package com.mycompany.resume;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRequestUtil {

    public static User requestProcess(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            throw new IllegalArgumentException("ID is not defined!");
        }

        Integer id = Integer.valueOf(idStr);
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getById(id);
        if (u == null) {
            throw new IllegalArgumentException("There is no user with this id!");
        }
        return u;
    }
}
