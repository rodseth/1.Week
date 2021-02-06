package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.BankCustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("xxx")
public class BankCustomerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final BankCustomerFacade FACADE =  BankCustomerFacade.getBankCustomerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getBankCustomerCount() {
        long count = FACADE.getBankCustomerCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
}
