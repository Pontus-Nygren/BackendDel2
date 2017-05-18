/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author QuagMir
 */
@Entity
public class Person implements Serializable {
    @Id@GeneratedValue
    private int id; //PK
    private String firstName;
    private String lastName;
    private String eMail;
    private String roletype; 
    private String passWord;
    
    @OneToMany(mappedBy = "person")
    @JsonBackReference
    private List<CsvClass> csvList;

   
    public Person() {
    }

      public Person(int id, String firstName, String lastName, String eMail, String role, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.roletype = role;
        this.passWord = passWord;
    }

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
       public List<CsvClass> getCsvList() {
        return csvList;
    }

    public void setCsvList(List<CsvClass> csvList) {
        this.csvList = csvList;
    }
  
    
            
}
