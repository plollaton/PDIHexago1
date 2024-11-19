package com.poc.pdihexago1.infra.jpa.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.pdihexago1.infra.jpa.entities.CustomerEntity;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
    
    CustomerEntity findByEmail(String email);
}
