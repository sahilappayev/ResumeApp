/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.User;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author SahilAppayev
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAll(String name, String surname, Integer age) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1 ";
        if (name != null && !name.trim().isEmpty()) {
            jpql += "and u.name = :name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += "and u.surname = :surname";
        }
        if (age != null) {
            jpql += "and u.age = :";
        }
        Query q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
//                System.out.println("Logged name");
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
//                System.out.println("Logged surname");
            q.setParameter("surname", surname);
        }
        if (age != null) {
//                System.out.println("Logged age");
            q.setParameter("age", age);
        }
//            System.out.println(jpql);
//            System.out.println("Name: "+name+"  Surname: "+surname+"  Age: "+age+"  i: "+i );
        return q.getResultList();
    }

        //JPQL
//    @Override
//    public User getByEmail(String email) {
//        User result = null;
//        EntityManager em = em();
//        Query q = em.createQuery("SELECT u FROM User u WHERE u.email= :email", User.class);
//        q.setParameter("email", email);
//        List<User> users = q.getResultList();
//        if (users.size() == 1) {
//            result = users.get(0);
//        }
//        return result;
//    }
    
        //CriteriaBuilder
//    @Override
//    public User getByEmail(String email) {
//        User result = null;
//        EntityManager em = em();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.where(criteriaBuilder.equal(root.get("email"),email));//where shertlerin , ile ayirmaqla artirmaq olar
//        Query query = em.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
//        if (users.size() == 1) {
//            result = users.get(0);
//        }
//        return result;
//    }
    
    //NativeSQL
//    @Override
//    public User getByEmail(String email) {
//        User result = null;
//        EntityManager em = em();
//        Query query = em.createNativeQuery("select * from user where email = ?", User.class);
//        query.setParameter(1, email);
//        List<User> users = query.getResultList();
//        if (users.size() == 1) {
//            result = users.get(0);
//        }
//        return result;
//    }
    
    //NamedQuery
    @Override
    public User getByEmail(String email) {
        User result = null;
        EntityManager em = em();
        Query query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (users.size() == 1) {
            result = users.get(0);
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        EntityManager em = em();
        User u = em.find(User.class, userId);
        em.close();
        return u;
    }

    @Override
    public boolean update(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = em();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean add(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em = em();
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean resetPassword(User u, String password) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        return update(u);
    }
}
