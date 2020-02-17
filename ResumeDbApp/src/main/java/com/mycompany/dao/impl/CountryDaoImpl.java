/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            statement.execute("select * from country where id=" + countryId);
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
    public boolean add(Country c) {
         try (Connection connection = connect()) {
             PreparedStatement statement = connection.prepareStatement("inster into skill (country_name, nationality) values (?, ?)");
            statement.setString(1, c.getCountryName());
            statement.setString(2, c.getNationality());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Country c) {
          try (Connection connection = connect()) {
             PreparedStatement statement = connection.prepareStatement("update skill set country_name = ?, nationality = ? where id="+c.getId());
            statement.setString(1, c.getCountryName());
            statement.setString(2, c.getNationality());
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
            return statement.execute("delete from country where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
