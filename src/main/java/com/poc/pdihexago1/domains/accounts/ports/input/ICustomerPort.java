package com.poc.pdihexago1.domains.accounts.ports.input;

import com.poc.pdihexago1.domains.accounts.dtos.AccountCustomerDto;
import com.poc.pdihexago1.domains.exceptions.CustomerNotFoundException;

public interface ICustomerPort {

    AccountCustomerDto getCustomerById(Long id) throws CustomerNotFoundException;

}
