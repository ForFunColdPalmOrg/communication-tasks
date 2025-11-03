package com.dk.tasks.adaptors.http.doc;

import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@Tag(name = "Manager API", description = "API endpoints for manager role employee operations")
//@SecurityScheme(type = SecuritySchemeType.HTTP,
//        scheme = "basic",
//        name = "BasicAuth",
//        description = "Basic authentication for customer operations")
public interface TaskControllerApi {

    @Operation(summary = "Show tasks available for employee",
            description = "Show all tasks that can be processed/assigned or already assigned to an employee",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Customer registered successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data"
                    )})
    void createTasks(CreateTaskRequest request);

    @Operation(summary = "Show tasks available for employee",
            description = "Show all tasks that can be processed/assigned or already assigned to an employee",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Customer registered successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data"
                    )})
    List<TaskResponse> showTasks(String user);
}
