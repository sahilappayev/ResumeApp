/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SahilAppayev
 */
public abstract class AbstractDao {

    private static EntityManagerFactory emf;
    
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume?serverTimezone=Asia/Baku";
        String user = "root";
        String password = "12345";
        return DriverManager.getConnection(url, user, password);
    }

    public static EntityManager em() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public static void emfClose() {
        emf.close();
    }
}
