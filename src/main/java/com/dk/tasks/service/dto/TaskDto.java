package com.dk.tasks.service.dto;

import com.dk.tasks.service.dto.enums.TaskState;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDto {
    private Integer teamId;
    private Integer createdBy;
    private Integer assignTo;
    private TaskState state;
    private LocalDateTime deadline;
    private String description;
    private String taxCode;
    private String lastName;
    private String name;
    private String middleName;
    private String phone;
    private String email;
    private Integer offerId;
}
