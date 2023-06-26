package com.application.moviedatabase.dto.mapper;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.entity.PersonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity toEntity(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( source.getId() );
        personEntity.setName( source.getName() );
        personEntity.setBirthDate( source.getBirthDate() );
        personEntity.setCountry( source.getCountry() );
        personEntity.setBiography( source.getBiography() );
        if ( source.getRole() != null ) {
            personEntity.setRole( Enum.valueOf( RoleType.class, source.getRole() ) );
        }

        return personEntity;
    }

    @Override
    public PersonDTO toDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( source.getId() );
        personDTO.setName( source.getName() );
        personDTO.setBirthDate( source.getBirthDate() );
        personDTO.setCountry( source.getCountry() );
        personDTO.setBiography( source.getBiography() );
        if ( source.getRole() != null ) {
            personDTO.setRole( source.getRole().name() );
        }

        return personDTO;
    }
}
