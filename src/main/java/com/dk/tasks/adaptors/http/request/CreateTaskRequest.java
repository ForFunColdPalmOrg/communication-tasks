package com.dk.tasks.adaptors.http.request;

import com.dk.tasks.service.dto.CustomerDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class CreateTaskRequest {
    @NotEmpty
    String createdBy;
    String assignTo;
    @NotNull(message = "Deadline is mandatory")
    LocalDateTime deadline;
    @NotEmpty(message = "Need at least 1 customer to create task")
    List<CustomerDto> customers;
}
