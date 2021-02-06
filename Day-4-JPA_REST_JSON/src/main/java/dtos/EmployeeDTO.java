
package dtos;

import entities.Employee;

/**
 *
 * @author MariHaugen
 */
public class EmployeeDTO {
    
    int id;
    String name;
    String address;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.address = employee.getAddress();
    }
    
    
    
    
}
