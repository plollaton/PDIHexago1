package com.poc.pdihexago1.domains.accounts.services;

import org.springframework.stereotype.Service;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
import com.poc.pdihexago1.domains.accounts.mappers.AccountCustomerMapper;
import com.poc.pdihexago1.domains.accounts.mappers.AccountMappers;
import com.poc.pdihexago1.domains.accounts.models.Account;
import com.poc.pdihexago1.domains.accounts.ports.input.IAccountApiPort;
import com.poc.pdihexago1.domains.accounts.ports.input.ICustomerPort;
import com.poc.pdihexago1.domains.accounts.ports.output.IAccountsRepository;
import com.poc.pdihexago1.domains.exceptions.CustomerNotFoundException;

@Service
public class AccountServices implements IAccountApiPort {

    private ICustomerPort customerPort;
    private AccountCustomerMapper accountCustomerMapper;
    private IAccountsRepository accountsRepository;
    private AccountMappers accountMappers;

    public AccountServices(ICustomerPort customerPort,
            AccountCustomerMapper accountCustomerMapper,
            IAccountsRepository accountsRepository,
            AccountMappers accountMappers) {
        this.customerPort = customerPort;
        this.accountCustomerMapper = accountCustomerMapper;
        this.accountsRepository = accountsRepository;
        this.accountMappers = accountMappers;
    }

    @Override
    public AccountDto addAccount(NewAccountDto newAccountDto) throws CustomerNotFoundException {

        Account account = new Account();
        account.setAccountNumber(newAccountDto.accountNumber());

        AccountCustomerDto customer = this.customerPort.getCustomerById(newAccountDto.customerId());
        account.setCustomer(this.accountCustomerMapper.fromAccountCustomerDto(customer));

        AccountDto accountDto = this.accountMappers.toAccountDto(account);

        accountDto = this.accountsRepository.save(accountDto);

        return accountDto;
    }

}
