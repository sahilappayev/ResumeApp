/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
@Repository
@Scope(value = "prototype")
@Transactional
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Country> root = cq.from(Country.class);
        cq.select(root);
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Country getById(int countryId) {
        Country result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Country> root = cq.from(Country.class);
        cq.select(root).where(cb.equal(root.get("id"),countryId));
        Query query = em.createQuery(cq);
        List<Country> countries = query.getResultList();
        if(countries.size() == 1){
            result = countries.get(0);
        }
        return result;
    }

    @Override
    public boolean add(Country c) {
        em.persist(c);
        return true;
    }

    @Override
    public boolean update(Country c) {
        em.merge(c);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Country c = em.find(Country.class, id);
        em.remove(c);
        return true;
    }

}
