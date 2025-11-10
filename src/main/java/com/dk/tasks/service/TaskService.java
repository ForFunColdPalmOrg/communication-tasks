package com.dk.tasks.service;

import com.dk.tasks.service.dto.CreateTaskDto;
import com.dk.tasks.service.dto.ReassignTaskDto;
import com.dk.tasks.service.dto.TaskDto;

import java.util.List;

public interface TaskService {

    void createTask(CreateTaskDto dto);

    List<TaskDto> getTasksByAssignedTo(Integer assignedTo);

    List<TaskDto> getTasksByCreatedBy(Integer createdBy);

    List<TaskDto> getTasksByTeam(Integer team);

    void requestTaskToReAssign(ReassignTaskDto dto);

    void acceptReassignRequest(ReassignTaskDto dto);
}
