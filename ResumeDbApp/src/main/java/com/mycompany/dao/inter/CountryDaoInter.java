/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface CountryDaoInter{
    public List<Country> getAll();
    public Country getById(int id);
    public boolean add(Country c);
    public boolean update(Country c);
    public boolean delete(int id);
}
