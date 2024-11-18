package com.poc.pdihexago1.domains.customers.models;

import com.poc.pdihexago1.domains.customers.validators.UniqueEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    
    @NotEmpty
    @NotBlank
    @Size(min=3)
    private String name;

    @Size(max=14)
    private String phone;

    @NotEmpty
    @NotBlank
    private String docNumber;

    @UniqueEmail
    @Email
    private String email;
}
