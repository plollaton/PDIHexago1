package com.poc.pdihexago1.infra.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "customerId", referencedColumnName = "id")
    private CustomerEntity customer;

}
