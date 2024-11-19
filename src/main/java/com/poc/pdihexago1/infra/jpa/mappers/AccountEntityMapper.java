package com.poc.pdihexago1.infra.jpa.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.infra.jpa.entities.AccountEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountEntityMapper {

    AccountEntity fromAccountDto(AccountDto accountDto);
    AccountDto toAccountDto(AccountEntity accountEntity);

}
