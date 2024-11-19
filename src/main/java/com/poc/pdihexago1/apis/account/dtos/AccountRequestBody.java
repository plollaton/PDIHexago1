package com.poc.pdihexago1.apis.account.dtos;

public record AccountRequestBody(
    String number,
    Long customerId
) {

}
