package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lam
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 6)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    BigDecimal salary;
    String firstName;
    String lastName;

    public Employee(String id,String firstName, String lastName,BigDecimal salary) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
    }
    

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee");
        sb.append("\nid: ").append(id);
        sb.append("\nsalary: ").append(salary);
        sb.append("\nfirstName: ").append(firstName);
        sb.append("\nlastName: ").append(lastName);
        return sb.toString();
    }

    
    
    

    
    
    
    
    
    
}
