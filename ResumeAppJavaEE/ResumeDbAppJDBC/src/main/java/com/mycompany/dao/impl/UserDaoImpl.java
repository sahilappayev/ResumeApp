/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SahilAppayev
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int age = rs.getInt("age");
        String phone = rs.getString("phone");
        String mail = rs.getString("email");
        String password = rs.getString("password");
        String adress = rs.getString("adress");
        String profileDescription = rs.getString("profile_description");
        Date birthDate = rs.getDate("birthdate");
        int birthPlaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String birthPlaceStr = rs.getString("birthplace");
        String nationalityStr = rs.getString("nationality");

        Country birthPlace = new Country(birthPlaceId, birthPlaceStr, null);
        Country nationality = new Country(nationalityId, null, nationalityStr);

        return new User(id, name, surname, age, phone, mail, password, adress, birthDate, birthPlace, nationality, profileDescription);
    }

    private User getUserSimple(ResultSet rs) throws Exception {
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
        String password = rs.getString("password");

        return new User(id, name, surname, age, phone, mail,password, adress, birthDate, null, null, profileDescription);
    }

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
                User user = getUser(rs);
                result.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        try(Connection connection = connect()){
            PreparedStatement statement = connection.prepareStatement("select * from user where email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                result = getUserSimple(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                    + "nationality_id = ?,"
                    + "password = ?"
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
            statement.setInt(10, u.getNationality().getId());
            statement.setString(11,crypt.hashToString(4,u.getPassword().toCharArray()));
            statement.setInt(12, u.getId());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            return statement.execute("delete from resume.user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(User u) {
        boolean b;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert into resume.user (name, surname, age, phone, email, adress, profile_description, birthdate, birthplace_id, nationality_id, password)"
                    + "valuse(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setInt(3, u.getAge());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getEmail());
            statement.setString(6, u.getAdress());
            statement.setString(7, u.getProfileDescription());
            statement.setDate(8, u.getBirthDate());
            statement.setInt(9, u.getBirthPlace().getId());
            statement.setInt(10, u.getNationality().getId());
            statement.setString(11,crypt.hashToString(4,u.getPassword().toCharArray()));
            b = statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    u.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Operation failed, no ID obtained!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return b;
    }

    public boolean resetPassword(User u, String password){
        u.setPassword(password);
        return update(u);
    }
}
