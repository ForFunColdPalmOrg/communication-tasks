package com.dk.tasks.service.mapper;

import com.dk.tasks.persistence.entity.TaskEntity;
import com.dk.tasks.service.dto.CreateTaskDto;
import com.dk.tasks.service.dto.TaskDto;
import com.dk.tasks.service.dto.enums.TaskState;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity createToEntity(CreateTaskDto dto, TaskState state);

    TaskDto toDto(TaskEntity entity);

    List<TaskDto> toDtos(List<TaskEntity> entity);
}
