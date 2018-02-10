package com.belajar.gitlabci.controller;

import com.belajar.gitlabci.entity.Customer;
import com.belajar.gitlabci.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer)throws Exception{
        customer = customerService.saveCustomer(customer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(customer, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable("id")String id, @Valid @RequestBody Customer customer)throws Exception{
        customer.setId(id);
        customer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id")String id)throws Exception{
        Customer customer  = customerService.findById(id);
        return new ResponseEntity<>(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer()throws Exception{
        return new ResponseEntity<>(customerService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }
}
