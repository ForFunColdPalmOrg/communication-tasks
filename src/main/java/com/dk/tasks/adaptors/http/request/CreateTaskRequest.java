package com.dk.tasks.adaptors.http.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CreateTaskRequest {
    @NotEmpty
    String requestId;
    @NotEmpty
    Integer createdBy;
    Integer assignTo;
    @NotNull(message = "Deadline is mandatory")
    LocalDateTime deadline;
    String description;
    String taxCode;
    @NotEmpty
    String lastName;
    String name;
    String middleName;
    @NotEmpty
    String phone;
    String email;
    Integer offerId;
}
