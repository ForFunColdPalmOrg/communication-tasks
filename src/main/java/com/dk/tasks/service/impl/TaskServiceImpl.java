package com.dk.tasks.service.impl;

import com.dk.tasks.persistence.repo.TaskRepo;
import com.dk.tasks.service.EmployeeService;
import com.dk.tasks.service.TaskService;
import com.dk.tasks.service.dto.CreateTaskDto;
import com.dk.tasks.service.dto.ReassignTaskDto;
import com.dk.tasks.service.dto.TaskDto;
import com.dk.tasks.service.dto.enums.TaskState;
import com.dk.tasks.service.exception.DoubleException;
import com.dk.tasks.service.exception.ErrorCode;
import com.dk.tasks.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final EmployeeService employeeService;
    private final TaskRepo repository;
    private final TaskMapper mapper;

    @Override
    @Transactional
    public void createTask(CreateTaskDto dto) {
        log.info("Received new create tasks requestId {}", dto.getRequestId());
        int teamId = checkEmployeesAndGetTeam(dto);
        if (repository.findByTaxCodeOrPhone(dto.getTaxCode(), dto.getPhone()).isEmpty()) {
            repository.save(mapper.createToEntity(dto, TaskState.NEW, teamId)); // todo add offer check
        } else {
            log.error(String.format("For client with tax_code %s, or phone %s, already exists task, requestId %s", dto.getTaxCode(), dto.getPhone(), dto.getRequestId()));
            throw new DoubleException(ErrorCode.TASK_DOUBLE, dto.getTaxCode(), dto.getPhone());
        }
    }

    @Override
    public List<TaskDto> getTasksByAssignedTo(Integer assignedTo) { // todo add offer detail
        return mapper.toDtos(repository.findAllTasksByAssignedTo(assignedTo));
    }

    @Override
    public List<TaskDto> getTasksByCreatedBy(Integer createdBy) { // todo add offer detail
        return mapper.toDtos(repository.findAllTasksByCreatedBy(createdBy));
    }

    @Override
    public List<TaskDto> getTasksByTeam(Integer teamId) {
        return mapper.toDtos(repository.findAllTasksByTeamId(teamId)); // todo add offer detail
    }

    @Override
    public void requestTaskToReAssign(ReassignTaskDto dto) {
        // todo for later, need to analyze
    }

    @Override
    public void acceptReassignRequest(ReassignTaskDto dto) {
        // todo for later, need to analyze
    }

    private Integer checkEmployeesAndGetTeam(CreateTaskDto dto) {
        if (null != dto.getAssignTo()) {
            employeeService.getEmployeeById(dto.getAssignTo());
        }
        return employeeService.getEmployeeById(dto.getCreatedBy()).getTeamId();
    }
}
