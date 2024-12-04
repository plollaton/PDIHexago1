package com.poc.pdihexago1.apis.customer.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.apis.customer.dtos.CustomerAccountResponseBody;
import com.poc.pdihexago1.domains.customers.dtos.CustomerAccountDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerAccountResponseMappers {

    CustomerAccountResponseBody toCustomerAccountResponseBody(CustomerAccountDto customerAccountDto);
    List<CustomerAccountResponseBody> toCustomerAccountResponseBodyList(List<CustomerAccountDto> customerAccountDtoList);

}
