package facades;

import utils.EMF_Creator;
import entities.BankCustomer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class BankCustomerFacadeTest {

    private static EntityManagerFactory emf;
    private static BankCustomerFacade facade;

    public BankCustomerFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = BankCustomerFacade.getBankCustomerFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("BankCustomer.deleteAllRows").executeUpdate();
            em.persist(new BankCustomer("Tom", "Hanks", "FG-34567", 900756, 2, "Customer lives abroad, behind the wall" ));
            em.persist(new BankCustomer("Brad", "Pitt", "FC-67421", 785642, 4, "Might be involved im criminal activities" ));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getBankCustomerCount(), "Expects two rows in the database");
    }
    

}
