package com.poc.pdihexago1.domains.customers.services;

import org.springframework.stereotype.Service;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.accounts.ports.input.ICustomerPort;
import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;
import com.poc.pdihexago1.domains.customers.mappers.CustomerMappers;
import com.poc.pdihexago1.domains.customers.models.Customer;
import com.poc.pdihexago1.domains.customers.ports.output.ICustomerRepository;

@Service
public class CustomerAccountServices implements ICustomerPort {

    private ICustomerRepository customerRepository;
    private CustomerMappers customerMappers;

    public CustomerAccountServices(ICustomerRepository customerRepository,
            CustomerMappers customerMappers) {
        this.customerRepository = customerRepository;
        this.customerMappers = customerMappers;
    }

    @Override
    public AccountCustomerDto getCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = this.customerRepository.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        return this.customerMappers.toAccountCustomerDto(customer);
    }

}
