/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.inter;

import com.mycompany.entity.UserSkill;

import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface UserSkillDaoInter {
    public boolean add(UserSkill us);
    public boolean update(UserSkill us);
    public boolean delete(int id);
    public List<UserSkill> getAllSkillByUserId(int userId);
}
