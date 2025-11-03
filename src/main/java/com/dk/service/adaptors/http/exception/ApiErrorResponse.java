package com.dk.service.adaptors.http.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class ApiErrorResponse {
    private List<ApiError> reasons;
}
