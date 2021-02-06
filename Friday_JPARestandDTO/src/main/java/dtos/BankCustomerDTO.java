/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class BankCustomerDTO {
    private Long id;
    
    String firstName;
    String lastName;
    String accountNumber;
    double balance;
    
    
    public static List<BankCustomerDTO> getDtos(List<BankCustomer> bankCustomerList){
        List<BankCustomerDTO> bcdtos = new ArrayList();
        bankCustomerList.forEach(bc->bcdtos.add(new BankCustomerDTO(bc)));
        return bcdtos;
    }


    public BankCustomerDTO(BankCustomer bankCustomer) {
        this.id = bankCustomer.getId();
        this.firstName = bankCustomer.getFirstName();
        this.lastName = bankCustomer.getLastName();
        this.accountNumber = bankCustomer.getAccountNumber();
        this.balance = bankCustomer.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    
    
    
    
    
    
}
