/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.User;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author SahilAppayev
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAll(String name, String surname, Integer age) {
        List<User> result = new ArrayList<>();
        try (Connection connection = connect()) {

            String sql = "SELECT"
                    + "	u.*,"
                    + "	c.country_name birthplace,"
                    + "	n.nationality "
                    + "FROM"
                    + "	USER u"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id where 1=1 ";

            if (name != null && !name.trim().isEmpty()) {
                sql += "and u.name =?";
            }
            if (surname != null && !surname.trim().isEmpty()) {
                sql += "and u.surname =?";
            }
            if (age != null) {
                sql += "and u.age =?";
            }

            PreparedStatement statement = connection.prepareStatement(sql);

            int i = 0;

            if (name != null && !name.trim().isEmpty()) {
//                System.out.println("Logged name");
                i++;
                statement.setString(i, name);
            }
            if (surname != null && !surname.trim().isEmpty()) {
//                System.out.println("Logged surname");
                i++;
                statement.setString(i, surname);
            }
            if (age != null) {
//                System.out.println("Logged age");
                i++;
                statement.setInt(i, age);
            }
//            System.out.println(sql);
//            System.out.println("Name: "+name+"  Surname: "+surname+"  Age: "+age+"  i: "+i );
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
//                User user = getUser(rs);
//                result.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        EntityManager em = em();
        result = em.find(User.class, userId);
        em.close();
        return result;
    }

    @Override
    public boolean update(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = em();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean add(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em = em();
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean resetPassword(User u, String password) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        return update(u);
    }
}
