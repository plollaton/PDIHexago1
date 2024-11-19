package com.poc.pdihexago1.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;

    @OneToOne
    @JoinColumn(columnDefinition = "customerId", referencedColumnName = "id")
    private CustomerEntity customer;

}
