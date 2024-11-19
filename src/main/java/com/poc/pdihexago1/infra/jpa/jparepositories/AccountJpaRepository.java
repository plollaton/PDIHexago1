package com.poc.pdihexago1.infra.jpa.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.pdihexago1.infra.jpa.entities.AccountEntity;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long>{

}
