package com.application.moviedatabase.dto.mapper;

import com.application.moviedatabase.dto.UserDTO;
import com.application.moviedatabase.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);

    UserEntity toEntity(UserDTO userDTO);
}
