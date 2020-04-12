/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from skill");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new Skill(id, name));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getById(int skillId) {
        Skill result = new Skill();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            statement.execute("select * from skill where id=" + skillId);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result = new Skill(id, name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean add(Skill s) {
        boolean b;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert into skill (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, s.getName());
            b = statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    s.setId(generatedKeys.getInt(1));
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

    @Override
    public boolean update(Skill s) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("update skill setb name = ? where id=" + s.getId());
            statement.setString(1, s.getName());
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
            return statement.execute("delete from skill where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
