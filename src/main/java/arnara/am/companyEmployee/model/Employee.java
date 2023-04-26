package arnara.am.companyEmployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Address address;
    private Company company;

    public Employee(String name, String surname, String email, String phoneNumber, Address address, Company company) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.company = company;
    }
}
