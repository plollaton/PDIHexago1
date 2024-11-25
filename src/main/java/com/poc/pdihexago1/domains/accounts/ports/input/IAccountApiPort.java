package com.poc.pdihexago1.domains.accounts.ports.input;

import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
import com.poc.pdihexago1.domains.exceptions.CustomerNotFoundException;

public interface IAccountApiPort {

    AccountDto addAccount(NewAccountDto newAccountDto) throws CustomerNotFoundException;

}
