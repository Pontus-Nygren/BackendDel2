/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.repository;

import com.mycompany.csvbackendreader.models.CsvClass;
import com.mycompany.csvbackendreader.models.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author QuagMir
 */
public class CsvRepo {
    // Lägga till ett CSV objekt för en viss person.
    PersonRepo pRepo = new PersonRepo();
     public CsvClass addCsv(int id, CsvClass csv){
        
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        csv.setPerson(pRepo.getPerson(id));
        pRepo.getPerson(id).getCsvList().add(csv);
        
//        for(int i=0; i<pRepo.getPersons().size(); i++ ){
//            if(pRepo.getPersons().get(i).getId() == id){
//                System.out.println("id i repo" + id);
//                csv.setPerson(pRepo.getPersons().get(i));
//                pRepo.getPersons().get(i).getCsvList().add(csv);
//                
//                }
            
        
//        }
                 session.save(csv);
                 session.getTransaction().commit();
                 session.close();
        
        return csv;
              
        
    
    }
    // få hela listan av alla CSV objekt
    public List<CsvClass> getCsvList(){
        Session session2 = NewHibernateUtil.getSession();
        List<CsvClass> persons = session2.createCriteria(CsvClass.class).list();
        
        
        
                return persons;
    
    }
    
    // behöver nog inte använda denna.. 
    public List<CsvClass> getPersonCsv(int personId){
//       List<CsvClass> csvListReturn = null;
//        System.out.println("Person REPO id" + personId);
////        for(int i = 0; i<pRepo.getPersons().size(); i++){
////            if(pRepo.getPersons().get(i).getId() == personId){
                Session session = NewHibernateUtil.getSession();
                session.beginTransaction();
//               List<Person> csvList = session2.createCriteria(Person.class).list();
//                for(int i =0; i<csvList.size(); i++){
//                if(csvList.get(i).getId() == personId){
//                    for(int j=0; j<csvList.get(i).getCsvList().size();j++){
//                        csvListReturn.add(csvList.get(i).getCsvList().get(j));
//                    
//                    }
//                
//                }
//                
//                }
////                csvList = pRepo.getPersons().get(i).getCsvList();
//                session2.beginTransaction().commit();
//                
////        List<CsvClass> csvList = session2.createCriteria(CsvClass.class).list();
////            }
////        }
//        
//        return csvListReturn;
//    

List<CsvClass> csv = (List<CsvClass>) session.createSQLQuery(
    "SELECT * FROM CsvClass WHERE person_id = :id")
    .addEntity(CsvClass.class)
    .setParameter("id", personId).list();

return csv;
    }
    
    
    public CsvClass updateCsv(CsvClass csv){
        System.out.println("UpdateCsv" + csv.getOrderNr());
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
       
        Query q = session.createQuery("update CsvClass set date = :newDate, CLName = :newLname, address = :newaddress, cFName = :newFname, comment = :newComment where orderNr = :orderNr");
        q.setParameter("newDate", csv.getDate());
        q.setParameter("newLname", csv.getCLName());
        q.setParameter("newaddress", csv.getAddress());
        q.setParameter("newFname", csv.getcFName());
        q.setParameter("newComment", csv.getComment());
        q.setParameter("orderNr", csv.getOrderNr());
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return csv;
    }
    
    public void removeCsv(int id){
            
            
            Session session = NewHibernateUtil.getSession();
            session.beginTransaction();
            
            Query q = session.createQuery("delete from CsvClass where orderNr = :id");
            q.setInteger("id", id);
            q.executeUpdate();
            session.getTransaction().commit();
            
            session.close();    
            System.out.println("Csv deleted" + id);
        }
}
