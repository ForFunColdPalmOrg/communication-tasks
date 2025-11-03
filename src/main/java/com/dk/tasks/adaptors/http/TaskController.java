package com.dk.tasks.adaptors.http;

import com.dk.tasks.adaptors.http.doc.TaskControllerApi;
import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController implements TaskControllerApi {

    @Override
    public void createTasks(CreateTaskRequest request) {

    }

    @Override
    public List<TaskResponse> showTasks(String user) {
        return null;
    }
}
