package com.dk.tasks.adaptors.http;

import com.dk.tasks.adaptors.http.doc.ManagerRestControllerApi;
import com.dk.tasks.adaptors.http.request.AssignTaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ManagerRestController implements ManagerRestControllerApi {
    @Override
    public void assignTasks(AssignTaskRequest request) {

    }
}
