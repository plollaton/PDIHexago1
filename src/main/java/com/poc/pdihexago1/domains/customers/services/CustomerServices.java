package com.poc.pdihexago1.domains.customers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerNewDto;
import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;
import com.poc.pdihexago1.domains.customers.mappers.CustomerMappers;
import com.poc.pdihexago1.domains.customers.models.Customer;
import com.poc.pdihexago1.domains.customers.ports.input.ICustomerApiPort;
import com.poc.pdihexago1.domains.customers.ports.output.ICustomerRepository;
import com.poc.pdihexago1.utils.FluentValidator;

@Service
public class CustomerServices implements ICustomerApiPort {

    private final CustomerMappers customerMappers;
    private final ICustomerRepository customerRepository;

    public CustomerServices(CustomerMappers customerMappers,
                            ICustomerRepository customerRepository) {
        this.customerMappers = customerMappers;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto addCustomer(CustomerNewDto customerNewDto) {

        Customer customer = this.customerMappers.fromCustomerNewDto(customerNewDto);

        FluentValidator validator = new FluentValidator();
        validator.validate(customer);
        if (!validator.isValid()){
            throw new IllegalArgumentException(validator.getErrorMessages());
        }

        Customer newCustomer = this.customerRepository.save(customer);

        return this.customerMappers.toCustomerDto(newCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) throws CustomerNotFoundException{
        
        Customer customer = this.customerRepository.getCustomerById(customerId);
        if (customer == null){
            throw new CustomerNotFoundException();
        }

        return this.customerMappers.toCustomerDto(customer);
        
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepository.getAllCustomers();

        return this.customerMappers.toCustomerDtoList(customers);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        this.customerRepository.deleteCustomerById(customerId);

    }
}
