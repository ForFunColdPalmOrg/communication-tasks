package com.dk.tasks.adaptors.http.doc;

import com.dk.tasks.adaptors.http.request.AssignTaskRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Manager API", description = "API endpoints for manager role employee operations")
//@SecurityScheme(type = SecuritySchemeType.HTTP,
//        scheme = "basic",
//        name = "BasicAuth",
//        description = "Basic authentication for customer operations")
public interface ManagerRestControllerApi {
    @Operation(summary = "Appoint task to employee",
            description = "Employee with manager role can appoint multiple tasks to process",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Customer registered successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data"
                    )})
    void assignTasks(AssignTaskRequest request);
}
