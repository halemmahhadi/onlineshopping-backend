package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.CustomerDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;
    private String password;
    private String email;
    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;

    @OneToOne(mappedBy = "customer")
    private Payment payment;
    public Customer() {
    }


    public long geId() {
        return customer_id;
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


    public static Customer from(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

}
