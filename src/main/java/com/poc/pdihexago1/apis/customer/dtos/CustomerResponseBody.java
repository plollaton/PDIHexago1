package com.poc.pdihexago1.apis.customer.dtos;

import java.util.List;

public record CustomerResponseBody(
        Integer id,
        String name,
        String phone,
        String docNumber,
        String email,
        List<CustomerAccountResponseBody> accounts
) {
}
