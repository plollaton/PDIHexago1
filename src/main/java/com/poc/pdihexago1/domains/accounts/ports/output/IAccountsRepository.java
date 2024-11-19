package com.poc.pdihexago1.domains.accounts.ports.output;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;

public interface IAccountsRepository {

    AccountDto save(AccountDto accountDto);

}
