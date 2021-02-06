/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.BankCustomerDTO;
import entities.BankCustomer;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        BankCustomerFacade bc = BankCustomerFacade.getBankCustomerFacade(emf);
        
        bc.addCustomer(new BankCustomer("Jon", "Snow", "GOT-34567", 900756, 2, "Customer lives abroad, behind the wall" ));
        bc.addCustomer(new BankCustomer("Al", "Swearengen", "DW-67421", 785642, 4, "Might be involved im criminal activities" ));
        bc.addCustomer(new BankCustomer("Mari", "Haugen", "RL-987653", 823, 5, "Spends all her money every month" ));
        bc.addCustomer(new BankCustomer("Frank", "vonSausage", "DOG-43213", 900756, 1, "Dog, always a good boy" ));
       
        
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
