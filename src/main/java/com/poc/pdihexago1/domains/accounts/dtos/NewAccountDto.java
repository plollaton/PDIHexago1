package com.poc.pdihexago1.domains.accounts.dtos;

public record NewAccountDto(
    String accountNumber,
    Long customerId
) {

}
