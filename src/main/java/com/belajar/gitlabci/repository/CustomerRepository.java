package com.belajar.gitlabci.repository;

import com.belajar.gitlabci.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
}
