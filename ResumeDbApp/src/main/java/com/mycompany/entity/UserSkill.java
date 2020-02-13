/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author SahilAppayev
 */
public class UserSkill {
    private Integer id;
    private User user;
    private Skill skill;
    private int level;

    public UserSkill() {
    }

    public UserSkill(Integer id, User user, Skill skill, int level) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", user=" + user + ", skill=" + skill + ", level=" + level + '}';
    }
   
}
