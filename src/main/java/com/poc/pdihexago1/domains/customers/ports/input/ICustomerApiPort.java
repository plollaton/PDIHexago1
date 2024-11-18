package com.poc.pdihexago1.domains.customers.ports.input;

import java.util.List;

import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerNewDto;
import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;

public interface ICustomerApiPort {

    CustomerDto addCustomer(CustomerNewDto customerNewDto);

    CustomerDto getCustomerById(Long customerId) throws CustomerNotFoundException;

    List<CustomerDto> getAllCustomers();

    public void deleteCustomer(Long customerId);
}
