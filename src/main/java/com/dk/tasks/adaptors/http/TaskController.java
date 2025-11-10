package com.dk.tasks.adaptors.http;

import com.dk.tasks.adaptors.http.doc.TaskControllerApi;
import com.dk.tasks.adaptors.http.mapper.TaskMapperHttp;
import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import com.dk.tasks.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/u1/v1/task", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskController implements TaskControllerApi {
    private final TaskService taskService;
    private final TaskMapperHttp mapper;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateTaskRequest request) {
        taskService.createTask(mapper.toDto(request));
    }

    @Override
    @GetMapping("/manager/id")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponse> showForManager(@PathVariable Integer id) {
        return mapper.toResponses(taskService.getTasksByCreatedBy(id));
    }

    @Override
    @GetMapping("/employee/id")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponse> showForEmployee(Integer id) {
        return mapper.toResponses(taskService.getTasksByAssignedTo(id));
    }
}
