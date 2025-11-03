package com.dk.tasks.service.impl;

import com.dk.tasks.persistence.entity.CustomerEntity;
import com.dk.tasks.persistence.repo.CustomerRepo;
import com.dk.tasks.service.CustomerService;
import com.dk.tasks.service.dto.CustomerDto;
import com.dk.tasks.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private static CustomerRepo customerRepo;
    private static CustomerMapper mapper;

    @Override
    @Transactional
    public CustomerDto findOrCreateCustomer(CustomerDto dto) {
        if (dto.getTaxCode().isEmpty() && dto.getPhone().isEmpty()) {
            return createNewCustomer(dto);
        }
        Optional<CustomerEntity> customerEntityOptional = customerRepo.findByTaxCodeOrPhone(dto.getTaxCode(), dto.getPhone());
        if (customerEntityOptional.isPresent()) {
            log.info("Found customer with taxCode {} or phone {}, no creation needed", dto.getTaxCode(), dto.getPhone());
            return mapper.toDto(customerEntityOptional.get());
        } else {
            return createNewCustomer(dto);
        }
    }

    private CustomerDto createNewCustomer(CustomerDto dto) {
        log.info("Not found customer with taxCode {} or phone {}, creation process initialized", dto.getTaxCode(), dto.getPhone());
        CustomerEntity newCustomer = mapper.toEntity(dto);
        return mapper.toDto(customerRepo.save(newCustomer));
    }
}
