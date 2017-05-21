/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.services;

import com.mycompany.csvbackendreader.models.CsvClass;
import com.mycompany.csvbackendreader.repository.CsvRepo;
import java.util.List;

/**
 *
 * @author QuagMir
 */
public class CsvService {
    CsvRepo csvRepo = new CsvRepo();
    
    public CsvClass addCsv(int id,CsvClass csv){
        System.out.println("id i service" + id);
        return csvRepo.addCsv(id, csv);
    
    }
    
    public List<CsvClass> getCsvList(){
    
        return csvRepo.getCsvList();
    }
    public List<CsvClass> getPersonCsv(int personId){
        return csvRepo.getPersonCsv(personId);
    
    }
    public CsvClass updateCsv(CsvClass csv){
    
        return csvRepo.updateCsv(csv);
    }
    public void removeCsv(int id){
        System.out.println("ServiceRemovecsv" + id);
        csvRepo.removeCsv(id);
    }
}
