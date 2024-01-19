package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.dto.CustomerDto;
import h2.connect.jpa.jpah2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody final CustomerDto customerDto) {
        Customer customer = customerService.addCustomer(Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDto> customerDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable final long id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable final long id) {
        Customer customer = customerService.deleteCustomer(id);
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CustomerDto> editCustomer(@PathVariable final long id, @RequestBody final CustomerDto customerDto) {
        Customer editedCustomer = customerService.editCustomer(id, Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDto.from(editedCustomer), HttpStatus.OK);
    }


}
