package com.dk.tasks.adaptors.http.mapper;

import com.dk.tasks.adaptors.http.request.CreateTaskRequest;
import com.dk.tasks.service.dto.CreateTaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapperHttp {

    CreateTaskDto toDto(CreateTaskRequest request);
}
