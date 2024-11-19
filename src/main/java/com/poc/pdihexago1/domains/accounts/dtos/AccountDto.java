package com.poc.pdihexago1.domains.accounts.dtos;

public record AccountDto(
    Long id,
    String number,
    AccountCustomerDto customer
) {

}
