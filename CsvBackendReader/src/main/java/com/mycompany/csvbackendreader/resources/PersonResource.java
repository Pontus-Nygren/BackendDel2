/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csvbackendreader.resources;

import com.mycompany.csvbackendreader.models.Person;

import com.mycompany.csvbackendreader.services.PersonService;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author QuagMir
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    PersonService pServ = new PersonService();
    
   @GET
    public List<Person> getPersons(){
        return pServ.getPersons();
    }
    
    @POST
    public Person addPerson(Person person){
        return pServ.addPerson(person);
    }
    
    @Path("/{personId}/csv")
    public CsvResource csv(){
    return new CsvResource();
    }
    
}
