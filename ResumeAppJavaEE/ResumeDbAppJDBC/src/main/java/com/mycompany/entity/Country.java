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
public class Country {
    private Integer id;
    private String countryName;
    private String nationality;

    public Country() {
    }

    public Country(Integer id, String countryName, String nationality) {
        this.id = id;
        this.countryName = countryName;
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "id=" + id + ", countryName=" + countryName + ", nationality=" + nationality +"\n";
    }
    
}
