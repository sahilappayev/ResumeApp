/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public interface EmploymentHistoryDaoInter {
    public boolean add(EmploymentHistory e);
    public boolean update(EmploymentHistory e);
    public boolean delete(EmploymentHistory e);
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
}
