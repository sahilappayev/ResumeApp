/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserSkillDaoInter;
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
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    @Override
    public boolean update(UserSkill us) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("update user_skill set user_id = ?, skill_id = ?, level = ? where id =" + us.getId());
            statement.setInt(1, us.getUser().getId());
            statement.setInt(2, us.getSkill().getId());
            statement.setInt(3, us.getLevel());
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
            return statement.execute("delete from user_skill where skill_id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(UserSkill us) {
        boolean b;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert into user_skill (user_id, skill_id, level) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, us.getUser().getId());
            statement.setInt(2, us.getSkill().getId());
            statement.setInt(3, us.getLevel());
            b = statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    us.setId(generatedKeys.getInt(1));
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

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");  //user_skill_id
        int userId = rs.getInt("user_id");
        int skillId = rs.getInt("skill_id");
        int level = rs.getInt("level");
        String name = rs.getString("skill_name");
        Skill skill = new Skill(skillId, name);
        return new UserSkill(id, new User(userId), skill, level);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT\n"
                    + "	us.*,\n"
                    + "	s.name AS skill_name \n"
                    + "FROM\n"
                    + "	user_skill AS us\n"
                    + "	INNER JOIN USER AS u ON u.id = us.user_id\n"
                    + "	INNER JOIN skill AS s ON us.skill_id = s.id where u.id = " + userId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                UserSkill userSkill = getUserSkill(rs);
                result.add(userSkill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
