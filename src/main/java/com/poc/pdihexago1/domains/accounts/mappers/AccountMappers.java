package com.poc.pdihexago1.domains.accounts.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.models.Account;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMappers {

    AccountDto toAccountDto(Account account);
    Account fromAccountDto(AccountDto accountDto);

}
