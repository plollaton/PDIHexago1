package com.poc.pdihexago1.domains.accounts.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    private String accountNumber;
    private AccountCustomer customer;


}
