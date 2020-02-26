/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.dao.AbstractDao;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface UserDaoInter{
    public List<User> getAll(String name, String surname, int age);
    public User getById(int id);
    public boolean add(User u);
    public boolean update(User u);
    public boolean delete(int id);
}
