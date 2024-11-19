package com.poc.pdihexago1.infra;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountEntityMapper {

    AccountEntity fromAccountDto(AccountDto accountDto);

}
