package com.poc.pdihexago1.domains.accounts.ports.input;

import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;

//import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
//import com.poc.pdihexago1.domains.customers.exceptions.CustomerNotFoundException;

public interface IAccountApiPort {

    void addAccount(NewAccountDto newAccountDto) throws CustomerNotFoundException;

}
