package com.poc.pdihexago1.apis.customer.dtos;

public record CustomerResponseBody(
        Integer id,
        String name,
        String phone,
        String docNumber,
        String email
) {
}
