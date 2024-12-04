package com.poc.pdihexago1.apis.customer.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.poc.pdihexago1.apis.customer.dtos.CustomerRequestBody;
import com.poc.pdihexago1.apis.customer.dtos.CustomerResponseBody;
import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerNewDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RequestCustomerMappers {

    CustomerNewDto toCustomerNewDto(CustomerRequestBody customerRequestBody);
    CustomerResponseBody toCustomerResponseBody(CustomerDto customerDto);
    List<CustomerResponseBody> toCustomerResponseBodyList(List<CustomerDto> customersDto);
}
