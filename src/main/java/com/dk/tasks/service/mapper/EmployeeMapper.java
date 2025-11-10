package com.dk.tasks.service.mapper;

import com.dk.tasks.persistence.entity.EmployeeEntity;
import com.dk.tasks.service.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "teamId", source = "team")
    @Mapping(target = "positionId", source = "position")
    EmployeeDto toDto(EmployeeEntity entity);
}
