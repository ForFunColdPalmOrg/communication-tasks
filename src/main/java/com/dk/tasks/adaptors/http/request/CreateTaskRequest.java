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
    @NotNull
    Integer createdBy;
    Integer assignTo;
    @NotNull
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
