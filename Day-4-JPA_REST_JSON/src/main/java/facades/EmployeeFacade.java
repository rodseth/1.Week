
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class EmployeeFacade {
    
    private static EntityManagerFactory emf;
    private static EmployeeFacade emFa;

    private EmployeeFacade() {}

    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (emFa== null) {
            emf = _emf;
            emFa = new EmployeeFacade();
        }
        return emFa;
    }
    
    public Employee getEmployeeById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Employee employee = em.find(Employee.class,id);
            
            return employee;
        }finally {
            em.close();
        }
    }
    
    public List<Employee> getEmployeesByName (String name) {
        EntityManager em = emf.createEntityManager();
         try{
             TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class);
             
             query.setParameter("name", name);
             return query.getResultList();
             }finally {
            em.close();
        }        
    }
    
     public List<Employee> getAllEmployees(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query =  em.createQuery("Select e from Employee e",Employee.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
     
    public List<Employee> getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query =  
                    em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)", Employee.class);
            return query.getResultList();
            }finally {
            em.close();
    }
    }
    
    public Employee createEmployee(String name, String address, int salary){
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        }finally {
            em.close();
        }
    }
   
}
