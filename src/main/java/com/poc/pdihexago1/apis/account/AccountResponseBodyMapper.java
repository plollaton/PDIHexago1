package com.poc.pdihexago1.apis.account;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.apis.account.dtos.AccountResponseBody;
import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountResponseBodyMapper {

    @Mapping(source = "customer.name", target = "customerName")
    AccountResponseBody fromAccountDto(AccountDto accountDto);

}
