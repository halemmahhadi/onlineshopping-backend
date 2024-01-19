package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Customer;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CustomerDto {

    private long id;
    private String password;
    private String email;

    public static CustomerDto from(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        return customerDto;

    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
