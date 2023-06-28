package com.application.moviedatabase.dto.mapper;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieEntity toEntity(MovieDTO source) {
        if ( source == null ) {
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setId( source.getId() );
        movieEntity.setName( source.getName() );
        movieEntity.setAvailable( source.isAvailable() );
        List<String> list = source.getGenres();
        if ( list != null ) {
            movieEntity.setGenres( new ArrayList<String>( list ) );
        }
        movieEntity.setYear( source.getYear() );

        return movieEntity;
    }

    @Override
    public MovieDTO toDTO(MovieEntity source) {
        if ( source == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setDirectorID( sourceDirectorId( source ) );
        if ( source.getId() != null ) {
            movieDTO.setId( source.getId() );
        }
        movieDTO.setName( source.getName() );
        movieDTO.setAvailable( source.isAvailable() );
        List<String> list = source.getGenres();
        if ( list != null ) {
            movieDTO.setGenres( new ArrayList<String>( list ) );
        }
        movieDTO.setYear( source.getYear() );
        movieDTO.setDateAdded( source.getDateAdded() );
        movieDTO.setDirector( personEntityToPersonDTO( source.getDirector() ) );
        movieDTO.setActors( personEntityListToPersonDTOList( source.getActors() ) );

        movieDTO.setActorIDs( getActorIds(source) );

        return movieDTO;
    }

    @Override
    public MovieEntity updateEntity(MovieDTO source, MovieEntity target) {
        if ( source == null ) {
            return target;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setAvailable( source.isAvailable() );
        if ( target.getGenres() != null ) {
            List<String> list = source.getGenres();
            if ( list != null ) {
                target.getGenres().clear();
                target.getGenres().addAll( list );
            }
            else {
                target.setGenres( null );
            }
        }
        else {
            List<String> list = source.getGenres();
            if ( list != null ) {
                target.setGenres( new ArrayList<String>( list ) );
            }
        }
        target.setYear( source.getYear() );

        return target;
    }

    private Long sourceDirectorId(MovieEntity movieEntity) {
        if ( movieEntity == null ) {
            return null;
        }
        PersonEntity director = movieEntity.getDirector();
        if ( director == null ) {
            return null;
        }
        long id = director.getId();
        return id;
    }

    protected PersonDTO personEntityToPersonDTO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personEntity.getId() );
        personDTO.setName( personEntity.getName() );
        personDTO.setBirthDate( personEntity.getBirthDate() );
        personDTO.setCountry( personEntity.getCountry() );
        personDTO.setBiography( personEntity.getBiography() );
        if ( personEntity.getRole() != null ) {
            personDTO.setRole( personEntity.getRole().name() );
        }

        return personDTO;
    }

    protected List<PersonDTO> personEntityListToPersonDTOList(List<PersonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonDTO> list1 = new ArrayList<PersonDTO>( list.size() );
        for ( PersonEntity personEntity : list ) {
            list1.add( personEntityToPersonDTO( personEntity ) );
        }

        return list1;
    }
}
