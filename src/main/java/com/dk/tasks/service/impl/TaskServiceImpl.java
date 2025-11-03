package com.dk.tasks.service.impl;

import com.dk.tasks.service.CustomerService;
import com.dk.tasks.service.EmployeeService;
import com.dk.tasks.service.TaskService;
import com.dk.tasks.service.dto.CreateTaskDto;
import com.dk.tasks.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private static CustomerService customerService;
    private static EmployeeService employeeService;

    @Override
    @Transactional
    public void createTasks(CreateTaskDto dto) {
        log.info("Received new create tasks requestId {}", dto.getRequestId());
        List<CustomerDto> customers = getCustomers(dto.getCustomers());
        //todo 2 - find or exception Employee(if assignTo is not blank check also this)
        //todo 3 - create task or exception, if there is task for requested client
    }

    private List<CustomerDto> getCustomers(List<CustomerDto> dtos) {
        List<CustomerDto> customers = new ArrayList<>();
        dtos.forEach(e -> customers.add(customerService.findOrCreateCustomer(e)));
        return customers;
    }
}
