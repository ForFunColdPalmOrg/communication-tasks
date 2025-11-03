package com.dk.tasks.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    String taxCode;
    @NotEmpty
    String lastName;
    String name;
    String middleName;
    @NotEmpty
    String phone;
    String email;
}
