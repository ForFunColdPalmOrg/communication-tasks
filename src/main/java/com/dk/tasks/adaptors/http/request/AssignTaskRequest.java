package com.dk.tasks.adaptors.http.request;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class AssignTaskRequest {
    String managerUsername;
    Set<Long> taskIds;
}
