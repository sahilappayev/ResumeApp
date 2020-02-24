/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author SahilAppayev
 */
public class User {
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String email;
    private String adress;
    private Date birthDate;
    private Country birthPlace;
    private Country natioanality;
    private String profileDescription;
    private List<UserSkill> skills;
    private List<EmploymentHistory> employmentHistorys;
    
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, int age, String phone, String email, String adress, Date birthDate, Country birthPlace, Country natioanality, String profileDescription, List<UserSkill> skills, List<EmploymentHistory> employmentHistorys) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.natioanality = natioanality;
        this.profileDescription = profileDescription;
        this.skills = skills;
        this.employmentHistorys = employmentHistorys;
    }
    
    
    
    public User(Integer id, String name, String surname, int age, String phone, String email, String adress, Date birthdate, Country birthplace, Country natioanality, String prifileDescription) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthdate;
        this.birthPlace = birthplace;
        this.natioanality = natioanality;
        this.profileDescription = prifileDescription;
        this.adress = adress;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return birthPlace;
    }

    public void setCountry(Country country) {
        this.birthPlace = country;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Country getNatioanality() {
        return natioanality;
    }

    public void setNatioanality(Country natioanality) {
        this.natioanality = natioanality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public List<EmploymentHistory> getEmploymentHistorys() {
        return employmentHistorys;
    }

    public void setEmploymentHistorys(List<EmploymentHistory> employmentHistorys) {
        this.employmentHistorys = employmentHistorys;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", phone=" + phone + ", email=" + email + ", adress=" + adress + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", natioanality=" + natioanality + ", profileDescription=" + profileDescription + ", skills=" + skills + ", employmentHistorys=" + employmentHistorys + '}';
    }
    
    
    
    
    
    
}
