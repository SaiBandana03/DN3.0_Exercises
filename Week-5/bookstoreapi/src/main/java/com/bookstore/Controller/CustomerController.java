package com.bookstore.Controller;

import com.bookstore.model.Customer;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        <Customer> com.bookstore.Controller.Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createCustomer(@Validated @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
            @Validated @RequestBody Customer customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhoneNumber(customerDetails.getPhoneNumber());
            return ResponseEntity.ok(customerRepository.save(customer));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}