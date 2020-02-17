/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.Country;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int age = rs.getInt("age");
        String phone = rs.getString("phone");
        String mail = rs.getString("email");
        String adress = rs.getString("adress");
        String profileDescription = rs.getString("profile_description");
        Date birthDate = rs.getDate("birthdate");
        int birthPlaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String birthPlaceStr = rs.getString("birthplace");
        String nationalityStr = rs.getString("nationality");

        Country birthPlace = new Country(birthPlaceId, birthPlaceStr, null);
        Country nationality = new Country(nationalityId, null, nationalityStr);

        return new User(id, name, surname, age, phone, mail, adress, birthDate, birthPlace, nationality, profileDescription);
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT\n"
                    + "	u.*,\n"
                    + "	c.country_name birthplace,\n"
                    + "	n.nationality \n"
                    + "FROM\n"
                    + "	USER u\n"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id\n"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                result.add(user);
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
            statement.execute("SELECT\n"
                    + "	u.*,\n"
                    + "	c.country_name birthplace,\n"
                    + "	n.nationality \n"
                    + "FROM\n"
                    + "	USER u\n"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id\n"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id where u.id=" + userId);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                result = user;
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
            PreparedStatement statement = connection.prepareStatement("update resume.user set name = ?,"
                    + " surname = ?,"
                    + " age = ?,"
                    + " phone = ?,"
                    + " email = ?,"
                    + " adress = ?,"
                    + " profile_description = ?,"
                    + "birthdate = ?,"
                    + "birthplace_id = ?,"
                    + "nationality_id = ?"
                    + " where id = ?");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setInt(3, u.getAge());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getEmail());
            statement.setString(6, u.getAdress());
            statement.setString(7, u.getProfileDescription());
            statement.setDate(8, u.getBirthDate());
            statement.setInt(9, u.getBirthPlace().getId());
            statement.setInt(10, u.getNatioanality().getId());
            statement.setInt(11, u.getId());
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
            return statement.execute("delete from resume.user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(User u) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert into resume.user (name, surname, age, phone, email, adress, profile_description, birthdate, birthplace_id, nationality_id)"
                    + "valuse(?,?,?,?,?,?,?,?,?,?) where id = ?");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setInt(3, u.getAge());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getEmail());
            statement.setString(6, u.getAdress());
            statement.setString(7, u.getProfileDescription());
            statement.setDate(8, u.getBirthDate());
            statement.setInt(9, u.getBirthPlace().getId());
            statement.setInt(10, u.getNatioanality().getId());
            statement.setInt(11, u.getId());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
