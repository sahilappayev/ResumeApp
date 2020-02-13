/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class Main {
    // bazani temsil eden klasslara model ve ya entity deyilir
    public static void main(String[] args) {
        EmploymentHistoryDaoInter userDao = Context.instanceEmploymentHistoryDao();
        List list = userDao.getAllEmploymentHistoryByUserId(1);
        System.out.println(list);
        
    }
}
