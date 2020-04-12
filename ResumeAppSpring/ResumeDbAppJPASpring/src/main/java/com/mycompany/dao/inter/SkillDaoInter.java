/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Skill;

import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface SkillDaoInter{
    public List<Skill> getAll();
    public Skill getById(int id);
    public boolean add(Skill s);
    public boolean update(Skill s);
    public boolean delete(int id);
}
