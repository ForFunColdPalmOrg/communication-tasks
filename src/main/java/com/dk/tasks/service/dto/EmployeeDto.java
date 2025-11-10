package com.dk.tasks.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private Integer id;
    private String userName;
    private Integer teamId;
    private Integer positionId;
}
