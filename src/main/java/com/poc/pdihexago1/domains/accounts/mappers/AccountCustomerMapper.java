package com.poc.pdihexago1.domains.accounts.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.accounts.models.AccountCustomer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountCustomerMapper {

    AccountCustomer fromAccountCustomerDto(AccountCustomerDto accountCustomerDto);

}
