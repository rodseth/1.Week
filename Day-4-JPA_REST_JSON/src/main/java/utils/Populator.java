/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import facades.EmployeeFacade;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MariHaugen
 */
public class Populator {
    
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EmployeeFacade EMFA = EmployeeFacade.getEmployeeFacade(emf);
        
        EMFA.createEmployee("Mari", "Nexø", 350000);
        EMFA.createEmployee("Nikolaj", "Nexø", 500000);
        EMFA.createEmployee("Torhild", "Skien", 980000);
        EMFA.createEmployee("Frank", "Balka", 16000);
    }
    public static void main(String[] args) {
        populate();
        
    }
            
           
    
}
