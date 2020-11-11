/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author SahilAppayev
 */
@Service
@Scope(value = "prototype")
@Transactional
public class UserServiceImpl implements UserServiceInter {

//    @PersistenceContext
//    EntityManager em;

    @Autowired
    @Qualifier("userDao1")
    UserDaoInter userDao;

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAll(String name, String surname, Integer age) {
        return userDao.getAll(name, surname, age);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public boolean update(User u) {
        return userDao.update(u);
    }

    @Override
    public boolean delete(int id) {
        return  userDao.delete(id);
    }

    @Override
    public boolean add(User u) {
        return userDao.add(u);
    }

    @Override
    public boolean resetPassword(User u, String password) {
       return userDao.resetPassword(u, password);
    }
}
