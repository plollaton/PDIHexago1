package com.poc.pdihexago1.infra.jpa.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.customers.models.Customer;
import com.poc.pdihexago1.infra.jpa.entities.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerEntityMapper {

    CustomerEntity fromCustomer(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
    List<Customer> toCustomerList(List<CustomerEntity> customersEntity);

    @Mapping(target="phone", ignore=true)
    @Mapping(target="docNumber", ignore=true)
    @Mapping(target="email", ignore = true)
    CustomerEntity fromAccountCustomerDto(AccountCustomerDto accountCustomerDto);
}
