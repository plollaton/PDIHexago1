package com.poc.pdihexago1.apis.account.dtos;

public record AccountResponseBody(
    Long id,
    String accountNumber,
    String customerName
) {

}
