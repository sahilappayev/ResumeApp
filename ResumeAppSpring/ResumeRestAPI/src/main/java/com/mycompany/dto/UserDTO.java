package com.mycompany.dto;

import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private List<UserSkillDTO> skills;

    public UserDTO() {
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.age = u.getAge();
        List<UserSkillDTO> list = new ArrayList<>();
        for (UserSkill userSkill : u.getUserSkillList()) {
            list.add(new UserSkillDTO(userSkill));
        }
        this.skills = list;
    }

    public UserDTO(Integer id, String name, String surname, Integer age, List<UserSkillDTO> skills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<UserSkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkillDTO> skills) {
        this.skills = skills;
    }
}
