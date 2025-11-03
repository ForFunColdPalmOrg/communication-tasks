package com.dk.tasks.adaptors.http;

import com.dk.tasks.adaptors.http.doc.TaskControllerApi;
import com.dk.tasks.adaptors.http.mapper.TaskMapperHttp;
import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import com.dk.tasks.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/u1/v1/task", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskController implements TaskControllerApi {
    private static TaskService taskService;
    private static TaskMapperHttp mapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTasks(@Valid CreateTaskRequest request) {
        taskService.createTasks(mapper.toDto(request));
    }

    @Override
    public List<TaskResponse> showTasks(String user) {
        return null;
    }
}
