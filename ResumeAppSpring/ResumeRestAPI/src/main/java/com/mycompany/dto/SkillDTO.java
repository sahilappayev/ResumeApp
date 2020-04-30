package com.mycompany.dto;

import com.mycompany.entity.Skill;

public class SkillDTO {
    private Integer id;
    private String name;

    public SkillDTO() {
    }

    public SkillDTO(Skill s) {
            this.id = s.getId();
            this.name = s.getName();
    }

    public SkillDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
