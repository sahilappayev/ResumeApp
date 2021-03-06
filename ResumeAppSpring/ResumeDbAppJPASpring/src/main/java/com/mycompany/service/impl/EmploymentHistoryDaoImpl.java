/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.service.inter.EmploymentHistoryDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    @Override
    public boolean add(EmploymentHistory e) {
        boolean b;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("insert into employment_history (header, begin_date, end_date, job_description, user_id)"
                    + " values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, e.getHeader());
            statement.setDate(2, (Date)e.getBeginDate());
            statement.setDate(3, (Date)e.getEndDate());
            statement.setString(4, e.getJobDescription());
            statement.setInt(5, e.getUser().getId());
            b = statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    e.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Operation failed, no ID obtained!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return b;
    }

    @Override
    public boolean update(EmploymentHistory e) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("update employment_history set header =?,"
                    + " begin_date =?,"
                    + " end_date = ?,"
                    + " job_description = ?"
                    + "where id=" + e.getId());
            statement.setString(1, e.getHeader());
            statement.setDate(2, (Date)e.getBeginDate());
            statement.setDate(3, (Date)e.getEndDate());
            statement.setString(4, e.getJobDescription());
            return statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(EmploymentHistory e) {
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            return statement.execute("delete from employment_history where id=" + e.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");

        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement("select * from employment_history where user_id=" + userId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                EmploymentHistory employmentHistory = getEmploymentHistory(rs);
                result.add(employmentHistory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
