package com.belajar.gitlabci.service;

import com.belajar.gitlabci.entity.Customer;
import com.belajar.gitlabci.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer saveCustomer(Customer customer)throws Exception{
        return customerRepository.save(customer);
    }

    public Customer findById(String id)throws Exception{
        return customerRepository.findOne(id);
    }

    public Iterable<Customer> findAll()throws Exception{
        return customerRepository.findAll();
    }
}