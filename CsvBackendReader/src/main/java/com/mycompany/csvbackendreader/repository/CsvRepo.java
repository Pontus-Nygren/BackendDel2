/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.repository;

import com.mycompany.csvbackendreader.models.CsvClass;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author QuagMir
 */
public class CsvRepo {
    // Lägga till ett CSV objekt för en viss person.
     public CsvClass addCsv(int id, CsvClass csv){
        PersonRepo pRepo = new PersonRepo();
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        
        for(int i=0; i<pRepo.getPersons().size(); i++ ){
            if(pRepo.getPersons().get(i).getId() == id){
                System.out.println("id i repo" + id);
                csv.setPerson(pRepo.getPersons().get(i));
                pRepo.getPersons().get(i).getCsvList().add(csv);
                
                }
            
        
        }
                 session.save(csv);
                 session.getTransaction().commit();
                 session.close();
        
        return csv;
              
        
    
    }
    // få hela listan av alla CSV objkt
    public List<CsvClass> getCsvList(){
        Session session2 = NewHibernateUtil.getSession();
        List<CsvClass> persons = session2.createCriteria(CsvClass.class).list();
        return persons;
    
    }
}
