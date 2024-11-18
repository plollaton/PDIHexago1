package com.poc.pdihexago1.domains.customers.dtos;

public record CustomerNewDto(
        String name,
        String phone,
        String docNumber,
        String email
) {
}
