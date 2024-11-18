package com.poc.pdihexago1.domains.customers.dtos;

public record CustomerDto(
        Long id,
        String name,
        String phone,
        String docNumber,
        String email
) {
}
