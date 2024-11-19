package com.poc.pdihexago1.infra;

import org.springframework.stereotype.Component;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.ports.output.IAccountsRepository;

@Component
public class AccountRepository implements IAccountsRepository {

    private AccountJpaRepository accountJpaRepository;
    private AccountEntityMapper accountEntityMapper;

    public AccountRepository(AccountEntityMapper accountEntityMapper,
            AccountJpaRepository accountJpaRepository) {
        this.accountEntityMapper = accountEntityMapper;
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public AccountDto save(AccountDto accountDto) {

        AccountEntity entity = this.accountEntityMapper.fromAccountDto(accountDto);
        System.out.println(entity);

        this.accountJpaRepository.save(entity);

        return this.accountEntityMapper.toAccountDto(entity);
    }

}
