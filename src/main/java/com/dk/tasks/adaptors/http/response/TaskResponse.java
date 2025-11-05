package com.dk.tasks.adaptors.http.response;

import com.dk.tasks.service.dto.enums.TaskState;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskResponse {
    Integer createdBy;
    Integer assignTo;
    TaskState state;
    LocalDateTime deadline;
    String description;
    String taxCode;
    String lastName;
    String name;
    String middleName;
    String phone;
    String email;
    Integer offerId;
}
