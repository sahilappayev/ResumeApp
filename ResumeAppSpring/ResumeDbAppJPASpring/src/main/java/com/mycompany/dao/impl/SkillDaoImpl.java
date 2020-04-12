/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SahilAppayev
 */
@Repository
@Transactional
public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Country> root = cq.from(Country.class);
        cq.select(root);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Skill getById(int skillId) {
        Skill result = new Skill();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Country> root = cq.from(Country.class);
        cq.select(root).where(cb.equal(root.get("id"), skillId));
        Query query = em.createQuery(cq);
        List<Skill> list = query.getResultList();
        if (list.size() == 1) {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public boolean add(Skill s) {
        em.persist(s);
        return true;
    }

    @Override
    public boolean update(Skill s) {
        em.merge(s);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Skill s = em.find(Skill.class, id);
        em.remove(s);
        return true;
    }

}
