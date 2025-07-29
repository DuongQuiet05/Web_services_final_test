package com.duong.finaltest.service;

import com.duong.finaltest.model.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findByUsername (String username);
}
