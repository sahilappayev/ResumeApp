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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter{
    
    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(User u) {
            return false;
    }

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
//        int id = rs.getInt("id");  //user_skill_id
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        int level = rs.getInt("level");
        String name = rs.getString("skill_name");
        Skill skill = new Skill(skillId,name);
        return new UserSkill(null,new User(userId), skill, level);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT\n"
                    + "	u.*,\n"
                    + "	us.level,\n"
                    + "	us.skill_id,\n"
                    + "	s.name AS skill_name \n"
                    + "FROM\n"
                    + "	user_skill AS us\n"
                    + "	LEFT JOIN USER AS u ON u.id = us.user_id\n"
                    + "	LEFT JOIN skill AS s ON us.id = s.id where u.id=" + userId);
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
