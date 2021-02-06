package Rest;

import com.google.gson.Gson;
import entity.Animal;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("animals_db")
public class AnimalsDBResource {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    Random rnd = new Random();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalsDBResource
     */
    public AnimalsDBResource() {
    }

    @Path("animals")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimals() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            return new Gson().toJson(animals);
        } finally {
            em.close();
        }
    }

    @Path("animalbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalById(@PathParam("id") int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Animal animal = em.find(Animal.class, id);
            if (animal == null) {
                return "No animal with that id.";
            } else {
                return new Gson().toJson(animal);
            }
        } finally {
            em.close();
        }
    }

    @Path("animalbytype/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalByType(@PathParam("type") String type) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Animal> query = em.createQuery(
                    "SELECT a FROM Animal a WHERE a.type = :type", Animal.class);
            query.setParameter("type", type);
            List<Animal> animals = query.getResultList();

            if (animals.size() == 0) {

                return "There is no animal of that type";

            } else {
                return new Gson().toJson(animals);
            }

        } finally {
            em.close();
        }
    }
    
    @Path("animal_random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomAnimal () {
        EntityManager em = emf.createEntityManager();
         try {
             TypedQuery<Animal> query = em.createQuery(
                    "SELECT a FROM Animal a", Animal.class);
             List<Animal> animals = query.getResultList();
             int size = animals.size() +1;

             
             int id = rnd.nextInt(size);
             Animal animal = em.find(Animal.class, id);
                          
             if (animals.isEmpty()) {
                 
                 return "There is no animals in the database.";
                                  
             } else {
                 return new Gson().toJson(animal);
                 
             }
         } finally {
             em.close();
         }
        
    }
}
