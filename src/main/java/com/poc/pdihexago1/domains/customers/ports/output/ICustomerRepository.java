package com.poc.pdihexago1.domains.customers.ports.output;

import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;

import java.util.List;


public interface ICustomerRepository {

    CustomerDto save(CustomerDto customerdto);

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();

    CustomerDto findOneByEmail(String email);

    public void deleteCustomerById(Long customerId);
}
