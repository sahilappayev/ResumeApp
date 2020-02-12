/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        
    }

    public static Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/resume?serverTimezone=UTC";
        String user = "root";
        String password = "12345";

        return DriverManager.getConnection(url, user, password);
    }
}
