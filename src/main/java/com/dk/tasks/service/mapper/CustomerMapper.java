package com.dk.tasks.service.mapper;

import com.dk.tasks.persistence.entity.CustomerEntity;
import com.dk.tasks.service.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDto entity);
}
