package com.poc.pdihexago1.domains.customers.validators;

import com.poc.pdihexago1.SpringContextHolder;
import com.poc.pdihexago1.domains.customers.ports.output.ICustomerRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        ICustomerRepository customerRepository = SpringContextHolder.getBean(ICustomerRepository.class);
        return customerRepository.findOneByEmail(email) == null;
    }
    
}
