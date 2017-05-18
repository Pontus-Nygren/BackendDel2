/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.resources;

import com.mycompany.csvbackendreader.models.CsvClass;
import com.mycompany.csvbackendreader.services.CsvService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author QuagMir
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CsvResource {
    CsvService cServ = new CsvService();
    @GET
    public List<CsvClass> getCsvList(){
    return cServ.getCsvList();
    }
    
    @POST
    @Path("/{personId}") // /person/id/csv/id
    public CsvClass addCsv(@PathParam("personId") int personId,CsvClass csv){
        System.out.println("Id i resource" + personId);
    return cServ.addCsv(personId, csv);
    }
}
