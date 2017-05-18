/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.repository;

import com.mycompany.csvbackendreader.models.Person;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author QuagMir
 */
public class PersonRepo {
    public Person addPerson(Person person){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        
        return person;
        
    
    }
    
    public List<Person> getPersons(){
        Session session2 = NewHibernateUtil.getSession();
        List<Person> persons = session2.createCriteria(Person.class).list();
        return persons;
    
    }
}
