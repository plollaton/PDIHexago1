package com.poc.pdihexago1.apis.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pdihexago1.apis.account.dtos.AccountRequestBody;
import com.poc.pdihexago1.apis.account.dtos.AccountResponseBody;
import com.poc.pdihexago1.domains.accounts.dtos.AccountDto;
import com.poc.pdihexago1.domains.accounts.dtos.NewAccountDto;
import com.poc.pdihexago1.domains.accounts.ports.input.IAccountApiPort;
import com.poc.pdihexago1.domains.exceptions.CustomerNotFoundException;

@RestController
public class AccountController {

    private IAccountApiPort accountApiPort;
    private AccountRequestBodyMapper accountRequestBodyMapper;
    private AccountResponseBodyMapper accountResponseBodyMapper;

    public AccountController(AccountRequestBodyMapper accountRequestBodyMapper,
            IAccountApiPort accountApiPort,
            AccountResponseBodyMapper accountResponseBodyMapper) {
        this.accountRequestBodyMapper = accountRequestBodyMapper;
        this.accountApiPort = accountApiPort;
        this.accountResponseBodyMapper = accountResponseBodyMapper;
    }

    @PostMapping("/account")
    ResponseEntity<AccountResponseBody> postAccount(@RequestBody AccountRequestBody requestBody) throws CustomerNotFoundException{
        NewAccountDto newAccountDto = this.accountRequestBodyMapper.toNewAccountDto(requestBody);
        AccountDto accountDto = this.accountApiPort.addAccount(newAccountDto);

        return ResponseEntity.ok(this.accountResponseBodyMapper.fromAccountDto(accountDto));
    }

}
