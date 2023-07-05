package com.application.moviedatabase.dto.mapper;

import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity toEntity(PersonDTO source);

    PersonDTO toDTO(PersonEntity source);

}
