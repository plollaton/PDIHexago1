package com.poc.pdihexago1.apis.customer.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CustomerRequestBody(
        @NotEmpty(message="Customer name cannot be empty.")        
        String name,
        
        @NotEmpty(message="Customer phone cannot be empty.")      
        String phone,
        
        @NotEmpty(message="Customer docNumber cannot be empty.")        
        String docNumber,
        
        @NotEmpty(message="Customer email cannot be empty.")
        @Email(message="Email should be valid.")        
        String email
) {
}
