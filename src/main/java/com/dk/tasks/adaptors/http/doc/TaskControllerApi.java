package com.dk.tasks.adaptors.http.doc;

import com.dk.tasks.adaptors.http.exception.ApiErrorResponse;
import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Manager API", description = "API endpoints for manager role employee operations")
//@SecurityScheme(type = SecuritySchemeType.HTTP,
//        scheme = "basic",
//        name = "BasicAuth",
//        description = "Basic authentication for customer operations")
public interface TaskControllerApi {

    @Operation(summary = "Create tasks",
            description = "Creates a set of tasks",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "CREATED"
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    )
            })
    void create(@Valid CreateTaskRequest request);

    @Operation(summary = "Show tasks created by a manager",
            description = "Show all tasks that certain manager created",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = List.class)
                    )
            ),
                    @ApiResponse(responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    )})
    List<TaskResponse> showForManager(@PathVariable Integer id);

    @Operation(summary = "Show tasks available for employee",
            description = "Show all tasks that assigned to an employee",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = List.class)
                    )
            ),
                    @ApiResponse(responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    )})
    List<TaskResponse> showForEmployee(@PathVariable Integer id);
}
