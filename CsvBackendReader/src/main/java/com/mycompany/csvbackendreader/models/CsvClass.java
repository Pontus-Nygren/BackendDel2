/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author QuagMir
 */
@Entity
public class CsvClass implements Serializable {

   String date;
   @Id
   String orderNr; // PK
   String cFName;
   String CLName;
   String address;
   String comment;
   
   
   @ManyToOne
   @JsonBackReference
   @JsonIgnore
   Person person;// referens (FK)

    public void setPerson(Person person) {
        this.person = person;
    }
//
//    public Person getPerson() {
//        return person;
//    }

   public CsvClass() {
    }
   
    public CsvClass(String date, String orderNr, String cFName, String CLName, String address, String comment) {
        this.date = date;
        this.orderNr = orderNr;
        this.cFName = cFName;
        this.CLName = CLName;
        this.address = address;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public String getcFName() {
        return cFName;
    }

    public void setcFName(String cFName) {
        this.cFName = cFName;
    }

    public String getCLName() {
        return CLName;
    }

    public void setCLName(String CLName) {
        this.CLName = CLName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
  

}
