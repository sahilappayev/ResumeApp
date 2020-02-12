/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.bean.User;
import com.mycompany.dao.AbstractDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDaoImpl extends AbstractDao {

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from user");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                String mail = rs.getString("email");
                result.add(new User(id, name, surname, age, phone, mail));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from user where id=" + userId);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                String mail = rs.getString("email");
                result = new User(id, name, surname, age, phone, mail);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(User u) {
        try (Connection connection = connect()) {
            //preventing sql injection
            //charecter encoding
            PreparedStatement statement = connection.prepareStatement("update user set name = ?, surname = ?, age = ?, phone = ?, email = ? where id = ?");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setInt(3, u.getAge());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getEmail());
            statement.setInt(6, u.getId());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = (PreparedStatement) connection.createStatement();
            return statement.execute("delete from user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
