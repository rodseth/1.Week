package facades;

import dtos.BankCustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade bFacade;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (bFacade == null) {
            emf = _emf;
            bFacade = new BankCustomerFacade();
        }
        return bFacade;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public BankCustomer addCustomer(BankCustomer bc){
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bc);
            em.getTransaction().commit();
            
            return bc;
        } finally {
            em.close();
        }
      
    }
    
    
    public BankCustomerDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new BankCustomerDTO(em.find(BankCustomer.class, id));
    }
    
     public List<BankCustomer> getByName (String name) {
        EntityManager em = emf.createEntityManager();
         try{
             TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BanCustomer b WHERE b.name = :name", BankCustomer.class);
             
             query.setParameter("name", name);
             return query.getResultList();
             }finally {
            em.close();
        }        
    }
     public List<BankCustomerDTO> getDTOByName(String name) {
        
        List<BankCustomer> list = bFacade.getByName(name);
        List<BankCustomerDTO> dtolist = new ArrayList<>();
        
        for (BankCustomer bankCustomer : list) {
            dtolist.add(new BankCustomerDTO(bankCustomer));
            
        }
        return dtolist;
        
    }
    
    //TODO Remove/Change this before use
    public long getBankCustomerCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long BankCustomerCount = (long)em.createQuery("SELECT COUNT(b) FROM BankCustomer b").getSingleResult();
            return BankCustomerCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<BankCustomer> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BankCustomer b", BankCustomer.class);
        List<BankCustomer> bankCustomers = query.getResultList();
        return bankCustomers;
        
    }
    
    public List<BankCustomerDTO> getAllDTO(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BankCustomer b", BankCustomer.class);
        List<BankCustomer> bankCustomers = query.getResultList();
        return BankCustomerDTO.getDtos(bankCustomers);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        BankCustomerFacade bcf = getBankCustomerFacade(emf);
        bcf.getAll().forEach(dto->System.out.println(dto));
    }

}
