/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from country");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String countryName = rs.getString("country_name");
                String nationality = rs.getString("nationality");
                result.add(new Country(id, countryName, nationality));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Country getById(int countryId) {
        Country result = new Country();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from country where id="+countryId);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String countryName = rs.getString("country_name");
                String nationality = rs.getString("nationality");
                result = new Country(id, countryName, nationality);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean add(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
