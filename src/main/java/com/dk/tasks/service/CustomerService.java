package com.dk.tasks.service;

import com.dk.tasks.service.dto.CustomerDto;

public interface CustomerService {

    CustomerDto findOrCreateCustomer(CustomerDto dto);
}
