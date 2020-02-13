/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
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
            statement.execute("select * from skill where id="+skillId);
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
