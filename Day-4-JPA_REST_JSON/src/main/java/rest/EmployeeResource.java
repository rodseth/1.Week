/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;


@Path("employee")
public class EmployeeResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final EmployeeFacade EMFA = EmployeeFacade.getEmployeeFacade(emf);

    @Context
    private UriInfo context;

    public EmployeeResource() {
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEmployees () {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = EMFA.getAllEmployees();
        
        for (Employee employee : employeeList){
            employeeDTOList.add(new EmployeeDTO(employee));
        }
        return gson.toJson(employeeDTOList);
        
        
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeById (@PathParam("id") int id) {
        
            EmployeeDTO employee = new EmployeeDTO(EMFA.getEmployeeById(id));
            return gson.toJson(employee);
            
        
        
    }
    
    @GET
    @Path("highestpaid")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestPaid () {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = EMFA.getEmployeesWithHighestSalary();
        
        for (Employee employee : employeeList){
            employeeDTOList.add(new EmployeeDTO(employee));
        }
        return gson.toJson(employeeDTOList);
        
        
    }
    
    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByName (@PathParam("name") String name) {
        
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = EMFA.getEmployeesByName(name);
        
        for (Employee employee : employeeList){
            employeeDTOList.add(new EmployeeDTO(employee));
        }
        return gson.toJson(employeeDTOList);
        
        
    }
    
  
    }


