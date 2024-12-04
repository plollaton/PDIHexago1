package com.poc.pdihexago1.infra.jpa.repositories;

import java.util.List;
import java.util.Optional;

import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import org.springframework.stereotype.Component;

import com.poc.pdihexago1.domains.customers.models.Customer;
import com.poc.pdihexago1.domains.customers.ports.output.ICustomerRepository;
import com.poc.pdihexago1.infra.jpa.entities.CustomerEntity;
import com.poc.pdihexago1.infra.jpa.jparepositories.CustomerJpaRepository;
import com.poc.pdihexago1.infra.jpa.mappers.CustomerEntityMapper;

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
    public CustomerDto save(CustomerDto customerDto) {

        CustomerEntity entity = this.customerJpaRepository.save(this.customerEntityMapper.fromCustomerDto(customerDto));


        return this.customerEntityMapper.toCustomerDto(entity);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Optional<CustomerEntity> entity = this.customerJpaRepository.findById(customerId);
        
        if (!entity.isPresent()){
            return null;
        }

        CustomerEntity y = entity.get();

        CustomerDto x = this.customerEntityMapper.toCustomerDto(y);
        return x;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> customersEntity = this.customerJpaRepository.findAll();
        return this.customerEntityMapper.toCustomerDtoList(customersEntity);
    }

    @Override
    public CustomerDto findOneByEmail(String email) {
        CustomerEntity entity = this.customerJpaRepository.findByEmail(email);
        return this.customerEntityMapper.toCustomerDto(entity);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        this.customerJpaRepository.deleteById(customerId);
    }
}
