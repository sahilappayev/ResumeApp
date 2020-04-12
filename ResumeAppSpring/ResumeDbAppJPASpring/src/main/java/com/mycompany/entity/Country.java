/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id"),
    @NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Country.findByNationality", query = "SELECT c FROM Country c WHERE c.nationality = :nationality")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "nationality")
    private String nationality;
    @OneToMany(mappedBy = "birthPlace")
    private List<User> userListBP;
    @OneToMany(mappedBy = "nationality")
    private List<User> userListNat;

    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
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

    public List<User> getUserListBP() {
        return userListBP;
    }

    public void setUserListBP(List<User> userList) {
        this.userListBP = userList;
    }

    public List<User> getUserListNat() {
        return userListNat;
    }

    public void setUserListNat(List<User> userList) {
        this.userListNat = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Country[ id=" + id + " ]";
    }
    
}
