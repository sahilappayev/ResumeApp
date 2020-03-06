/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.User;

import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface UserDaoInter{
    public List<User> getAll(String name, String surname, Integer age);
    public User getByEmailAndPassword(String email, String password);
    public User getById(int id);
    public boolean add(User u);
    public boolean update(User u);
    public boolean delete(int id);
}
