package com.bookstore.Controller;

import com.bookstore.model.Customer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    /*@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Customer createCustomer(@RequestBody Customer customer) {
    customers.add(customer);
    return customer;
}*/
@PostMapping
public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    customers.add(customer);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "CustomValue");

    return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
}


    @PostMapping("/register")
public String registerCustomer(@RequestParam String name, @RequestParam String email) {
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmail(email);
    customers.add(customer);
    return "Customer registered successfully!";
}


}

