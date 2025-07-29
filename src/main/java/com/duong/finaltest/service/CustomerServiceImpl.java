package com.duong.finaltest.service;

import com.duong.finaltest.model.entity.Customer;
import com.duong.finaltest.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepo customerRepo;

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerRepo.findCustomerByUsername(username);
    }
}
