package com.poc.pdihexago1.infra.jpa.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String phone;
    private String docNumber;
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<AccountEntity> accounts;

}
