
package Facade;

import Entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

    
    public class CustomerFacade {
  EntityManagerFactory emf;

  public CustomerFacade(EntityManagerFactory emf) {
    this.emf = emf;
  }

  private EntityManager getEntityManager(){ 
     return emf.createEntityManager();
  }

  public List<Customer> getAllCustomers(){
    	EntityManager em = getEntityManager();
    	TypedQuery q = em.createQuery("SELECT c FROM Customer c", Customer.class);
    	return q.getResultList();
	}
  
  public Customer findById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer customer = em.find(Customer.class,id);
            return customer;
        }finally {
            em.close();
        }
    }
     public List<Customer> findByLastName(String name){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select c from Customer c where c.lastname = :name ", Customer.class);
            query.setParameter("name", name);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
public int getNumberOfCustomers(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select c from Customer c",Customer.class);
            return query.getResultList().size();
        
        }finally {
            em.close();
        }
       }
     
    public List<Customer> allCustomers(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select c from Customer c",Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
        
    }
   
      public Customer addCustomer(Customer c){
        EntityManager em = emf.createEntityManager();
        
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            em.close();
            return c;
            
    }
      
        public static void main(String[] args) {
            CustomerFacade cf = new CustomerFacade(Persistence.createEntityManagerFactory("pu"));
            
            cf.addCustomer(new Customer("Frank", "vonSausage"));
            
            List<Customer> customers = cf.getAllCustomers();
            for (Customer c : customers) {
                System.out.println(c.getFirstName());
            }
            
            int numberOfCustomers = cf.getNumberOfCustomers();
            System.out.println(numberOfCustomers);
            
            
            
        }


  }
  
