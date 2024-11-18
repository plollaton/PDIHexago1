package com.poc.pdihexago1.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.poc.pdihexago1.domains.customers.models.Customer;
import com.poc.pdihexago1.domains.customers.ports.output.ICustomerRepository;

@Component
public class CustomerRepository implements ICustomerRepository {

    private final CustomerEntityMapper customerEntityMapper;
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepository(CustomerEntityMapper customerEntityMapper,
                              CustomerJpaRepository customerJpaRepository) {
        this.customerEntityMapper = customerEntityMapper;
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {

        CustomerEntity entity = this.customerJpaRepository.save(this.customerEntityMapper.fromCustomer(customer));


        return this.customerEntityMapper.toCustomer(entity);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<CustomerEntity> entity = Optional.of(this.customerJpaRepository.getReferenceById(customerId));
        if (entity.isPresent()){
            return null;
        }

        return this.customerEntityMapper.toCustomer(entity.get());
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customersEntity = this.customerJpaRepository.findAll();
        return this.customerEntityMapper.toCustomerList(customersEntity);
    }

    @Override
    public Customer findOneByEmail(String email) {
        CustomerEntity entity = this.customerJpaRepository.findOneByEmail(email);
        return this.customerEntityMapper.toCustomer(entity);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        this.customerJpaRepository.deleteById(customerId);
    }
}
