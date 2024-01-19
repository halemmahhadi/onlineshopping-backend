package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.CustomerNotFoundException;
import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.repo.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Data
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){

        return customerRepository.save(customer);
    }
    public List<Customer>getCustomers(){
        return StreamSupport
                .stream(customerRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
    public Customer getCustomer(long id){
        return customerRepository.findById(id)
                .orElseThrow(()->
                new CustomerNotFoundException(id));
    }

    public Customer deleteCustomer(long id){
     Customer customer=getCustomer(id);
     customerRepository.delete(customer);
     return customer;

    }
@Transactional
    public Customer editCustomer(long id,Customer customer){
        Customer customerToEdit=getCustomer(id);
        customerToEdit.setPassword(customer.getPassword());
        customerToEdit.setEmail(customer.getEmail());
        return  customerToEdit;


    }

}
