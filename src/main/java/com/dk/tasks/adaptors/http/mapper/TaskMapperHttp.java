package com.dk.tasks.adaptors.http.mapper;

import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.adaptors.http.response.TaskResponse;
import com.dk.tasks.service.dto.CreateTaskDto;
import com.dk.tasks.service.dto.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapperHttp {

    CreateTaskDto toDto(CreateTaskRequest request);

    TaskResponse toResponse(TaskDto dto);

    List<TaskResponse> toResponses(List<TaskDto> dtos);
}
