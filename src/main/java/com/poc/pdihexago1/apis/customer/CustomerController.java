package com.poc.pdihexago1.apis.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pdihexago1.apis.customer.dtos.CustomerRequestBody;
import com.poc.pdihexago1.apis.customer.dtos.CustomerResponseBody;
import com.poc.pdihexago1.apis.customer.mappers.RequestCustomerMappers;
import com.poc.pdihexago1.domains.customers.dtos.CustomerDto;
import com.poc.pdihexago1.domains.customers.dtos.CustomerNewDto;
import com.poc.pdihexago1.domains.customers.ports.input.ICustomerApiPort;
import com.poc.pdihexago1.domains.exceptions.CustomerNotFoundException;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

    private final ICustomerApiPort customerApiPort;
    private final RequestCustomerMappers customerMappers;

    public CustomerController(ICustomerApiPort customerApiPort,
                              RequestCustomerMappers customerMappers) {
        this.customerApiPort = customerApiPort;
        this.customerMappers = customerMappers;
    }

    @PostMapping("/customer")
    ResponseEntity<CustomerResponseBody> addCustomer(@Valid @RequestBody CustomerRequestBody customerRequestBody) {
        CustomerNewDto newCustomer = this.customerMappers.toCustomerNewDto(customerRequestBody);
        CustomerDto customerDto = this.customerApiPort.addCustomer(newCustomer);

        CustomerResponseBody responseBody = this.customerMappers.toCustomerResponseBody(customerDto);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<CustomerResponseBody> getCustomerById(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException{
        CustomerDto customerDto = this.customerApiPort.getCustomerById(customerId);
        return ResponseEntity.ok(this.customerMappers.toCustomerResponseBody(customerDto));
    }

    @DeleteMapping("/customer/{customerId}")
    ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") Long customerId){
        this.customerApiPort.deleteCustomer(customerId);
        
        return ResponseEntity.ok("");
    }

    @GetMapping("/customers")
    ResponseEntity<List<CustomerResponseBody>> getAllCustomers(){
        List<CustomerDto> customers = this.customerApiPort.getAllCustomers();

        return ResponseEntity.ok(this.customerMappers.toCustomerResponseBodyList(customers));
    }
}
