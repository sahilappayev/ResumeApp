/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();
        List<User> list = userDao.getAll();
        System.out.println(list);
    
        
    }   
}
