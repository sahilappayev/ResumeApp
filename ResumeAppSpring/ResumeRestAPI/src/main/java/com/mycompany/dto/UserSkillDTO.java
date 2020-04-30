package com.mycompany.dto;


import com.mycompany.entity.UserSkill;

public class UserSkillDTO {
    private Integer id;
    private Integer level;
    private SkillDTO skillDTO;

    public UserSkillDTO() {
    }

    public UserSkillDTO(UserSkill us) {
            this.id = us.getId();
            this.level = us.getLevel();
            this.skillDTO = new SkillDTO(us.getSkill());
    }

    public UserSkillDTO(Integer id, Integer level, SkillDTO skillDTO) {
        this.id = id;
        this.level = level;
        this.skillDTO = skillDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public SkillDTO getSkillDTO() {
        return skillDTO;
    }

    public void setSkillDTO(SkillDTO skillDTO) {
        this.skillDTO = skillDTO;
    }
}
