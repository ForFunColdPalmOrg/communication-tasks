package com.dk.tasks.service.impl;

import com.dk.tasks.persistence.entity.EmployeeEntity;
import com.dk.tasks.persistence.repo.EmployeeRepo;
import com.dk.tasks.service.EmployeeService;
import com.dk.tasks.service.dto.EmployeeDto;
import com.dk.tasks.service.exception.ErrorCode;
import com.dk.tasks.service.exception.NotFoundException;
import com.dk.tasks.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        if (employee.isEmpty()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND_EMPLOYEE, id);
        }
        return mapper.toDto(employee.get());
    }
}
