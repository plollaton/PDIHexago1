package com.poc.pdihexago1.apis.account;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.apis.account.dtos.AccountRequestBody;
import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountRequestBodyMapper {

    NewAccountDto toNewAccountDto(AccountRequestBody requestBody);

}
