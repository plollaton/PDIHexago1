package com.poc.pdihexago1.domains.accounts.services;

import org.springframework.stereotype.Service;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
import com.poc.pdihexago1.domains.accounts.mappers.AccountCustomerMapper;
import com.poc.pdihexago1.domains.accounts.mappers.AccountMappers;
import com.poc.pdihexago1.domains.accounts.models.Account;
import com.poc.pdihexago1.domains.accounts.models.AccountCustomer;
//import com.poc.pdihexago1.domains.accounts.dtos.CustomerAccountDto;
//import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
//import com.poc.pdihexago1.domains.accounts.mappers.AccountMappers;
//import com.poc.pdihexago1.domains.accounts.models.Account;
import com.poc.pdihexago1.domains.accounts.ports.input.IAccountApiPort;
//import com.poc.pdihexago1.domains.accounts.ports.input.ICustomerAccountPort;
//import com.poc.pdihexago1.domains.accounts.ports.output.IAccountsRepository;
//import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
//import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;
//import com.poc.pdihexago1.domains.customers.models.Customer;
//import com.poc.pdihexago1.domains.customers.ports.input.ICustomerApiPort;
import com.poc.pdihexago1.domains.accounts.ports.input.ICustomerPort;
import com.poc.pdihexago1.domains.accounts.ports.output.IAccountsRepository;
import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;

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
    public void addAccount(NewAccountDto newAccountDto) throws CustomerNotFoundException {

        Account account = new Account();
        account.setNumber(newAccountDto.number());

        AccountCustomerDto customer = this.customerPort.getCustomerById(newAccountDto.customerId());
        account.setCustomer(this.accountCustomerMapper.fromAccountCustomerDto(customer));

        this.accountsRepository.save(this.accountMappers.toAccountDto(account));

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAccount'");
    }

}
