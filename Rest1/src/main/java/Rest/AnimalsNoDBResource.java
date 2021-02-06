/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author MariHaugen
 */
@Path("animals")
public class AnimalsNoDBResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalsResource
     */
    public AnimalsNoDBResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.AnimalsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        //TODO return proper representation object
        return "Vuf...(Message from a dog)";
    }
    
    @GET
    @Path("animal_list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAnimals () {
        return  "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";
    }
    
    @GET
    @Path("animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOneAnimal() {
        
        AnimalNoDB animal = new AnimalNoDB("Katt", "Mjau");
        return new Gson().toJson(animal);
    }

    


    /**
     * PUT method for updating or creating an instance of AnimalsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
