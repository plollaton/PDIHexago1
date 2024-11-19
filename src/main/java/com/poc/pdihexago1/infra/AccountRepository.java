package com.poc.pdihexago1.infra;

import org.springframework.stereotype.Component;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.ports.output.IAccountsRepository;

@Component
public class AccountRepository implements IAccountsRepository {

    private AccountJpaRepository accountJpaRepository;
    private AccountEntityMapper AccountEntityMapper;

    public AccountRepository(AccountEntityMapper accountEntityMapper,
            AccountJpaRepository accountJpaRepository) {
        this.AccountEntityMapper = accountEntityMapper;
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public void save(AccountDto accountDto) {

        AccountEntity entity = this.AccountEntityMapper.fromAccountDto(accountDto);
        System.out.println(entity);

        this.accountJpaRepository.save(entity);

    }

}
