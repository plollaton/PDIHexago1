package com.poc.pdihexago1.domains.customers.ports.output;

import java.util.List;

import com.poc.pdihexago1.domains.customers.models.Customer;

public interface ICustomerRepository {

    Customer save(Customer customer);

    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomers();

    Customer findOneByEmail(String email);

    public void deleteCustomerById(Long customerId);
}
