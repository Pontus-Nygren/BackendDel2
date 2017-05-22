/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.services;

import com.mycompany.csvbackendreader.models.Person;
import com.mycompany.csvbackendreader.repository.PersonRepo;
import java.util.List;


/**
 *
 * @author QuagMir
 */
public class PersonService {
    
    
    PersonRepo pR = new PersonRepo();
    
   
    public List<Person> getPersons(){
        return pR.getPersons();
    }
    public Person getPerson(int id){
    return pR.getPerson(id);
    }
    
    
    public Person addPerson(Person person){
        return pR.addPerson(person);
    }
    
    
}
