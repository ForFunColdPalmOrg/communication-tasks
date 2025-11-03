package com.dk.tasks.service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CreateTaskDto {
    private String requestId;
    private String createdBy;
    private String assignTo;
    private LocalDateTime deadline;
    private List<CustomerDto> customers;
}
