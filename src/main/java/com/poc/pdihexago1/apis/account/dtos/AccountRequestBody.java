package com.poc.pdihexago1.apis.account.dtos;

public record AccountRequestBody(
    String accountNumber,
    Long customerId
) {

}
