package com.poc.pdihexago1.infra.jpa.mappers;

import java.util.List;

import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import org.mapstruct.*;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.infra.jpa.entities.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerEntityMapper {

    CustomerEntity fromCustomerDto(CustomerDto customer);
    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customersEntity);
}
