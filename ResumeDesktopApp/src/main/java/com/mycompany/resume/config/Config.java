/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resume.config;

import com.mycompany.entity.Country;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Config {
    private static Config config;
    private User loggedInUser;
    private EmploymentHistory userHistory;
    List<Country> countryList;
    List<Skill> skills;

    private Config(){
       
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public EmploymentHistory getUserHistory() {
        return userHistory;
    }

    public void setUserHistory(EmploymentHistory userHistory) {
        this.userHistory = userHistory;
    }

    public static Config creatConfig(){
        if(config == null){
            config = new Config();
        }
        return config;
    }
}
