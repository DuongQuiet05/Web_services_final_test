package com.duong.finaltest.validate;

import com.duong.finaltest.model.entity.Customer;
import com.duong.finaltest.service.CustomerService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ValidUsernameImpl implements ConstraintValidator<ValidUsername,String> {
    private final CustomerService customerService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.isBlank()) return true;

        Optional<Customer> customerOptional = customerService.findByUsername(s);
        if(customerOptional.isEmpty()) return  true;
        return false;
    }
}
