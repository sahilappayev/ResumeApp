/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;

import java.util.Scanner;

/**
 *
 * @author SahilAppayev
 */
public class Main {
    // bazani temsil eden klasslara model ve ya entity deyilir
    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getById(1);
        System.out.println(u.getName());
        Scanner sc = new Scanner(System.in);
        System.out.println("Set user password:");
        String password = sc.nextLine();
        u.setPassword(password);
        userDao.update(u);
    }
}