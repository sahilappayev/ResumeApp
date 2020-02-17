/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.User;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    @Override
    public boolean add(EmploymentHistory e) {
        try(Connection connection = connect()){
            PreparedStatement statement = connection.prepareStatement("insert into employment_history (header, begin_date, end_date, job_description)"
                    + " values (?,?,?,?) where user_id="+e.getUser().getId());
            statement.setString(1,e.getHeader() );
            statement.setDate(2,e.getBeginDate() );
            statement.setDate(3,e.getEndDate() );
            statement.setString(4, e.getJobDescription());
            return statement.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EmploymentHistory e) {
         try(Connection connection = connect()){            
            PreparedStatement statement = connection.prepareStatement("update employment_history set header =?,"
                    + " begin_date =?,"
                    + " end_date = ?,"
                    + " job_description = ?"
                    + "where user_id="+e.getUser().getId());
            statement.setString(1,e.getHeader() );
            statement.setDate(2,e.getBeginDate() );
            statement.setDate(3,e.getEndDate() );
            statement.setString(4, e.getJobDescription());
            return statement.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try(Connection connection = connect()){
        Statement statement = connection.createStatement();
        return statement.execute("delete from employment_history where id="+id);
        }catch(Exception ex){
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
