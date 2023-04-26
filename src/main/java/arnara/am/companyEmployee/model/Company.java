package arnara.am.companyEmployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private Address address;

    public Company(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }
}
