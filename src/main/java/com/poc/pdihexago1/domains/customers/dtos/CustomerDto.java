package com.poc.pdihexago1.domains.customers.dtos;

import java.util.List;

public record CustomerDto(
        Long id,
        String name,
        String phone,
        String docNumber,
        String email,
        List<CustomerAccountDto> accounts
) {
}
