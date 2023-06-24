package com.application.moviedatabase.dto.mapper;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieEntity toEntity(MovieDTO source);

    MovieDTO toDTO(MovieEntity source);

    MovieEntity updateEntity(MovieDTO source, @MappingTarget MovieEntity target);

}
