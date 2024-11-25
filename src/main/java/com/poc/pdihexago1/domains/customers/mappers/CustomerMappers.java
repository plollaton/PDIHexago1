package com.poc.pdihexago1.domains.customers.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerNewDto;
import com.poc.pdihexago1.domains.customers.models.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMappers {

    @Mapping(target = "id", ignore = true)
    Customer fromCustomerNewDto(CustomerNewDto customerNewDto);

    CustomerDto toCustomerDto(Customer customer);

    List<CustomerDto> toCustomerDtoList(List<Customer> customers);

    AccountCustomerDto toAccountCustomerDto(CustomerDto customer);
}
