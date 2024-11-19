package com.poc.pdihexago1.infra;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.customers.models.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerEntityMapper {

    CustomerEntity fromCustomer(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
    List<Customer> toCustomerList(List<CustomerEntity> customersEntity);

    CustomerEntity fromAccountCustomerDto(AccountCustomerDto accountCustomerDto);
}
