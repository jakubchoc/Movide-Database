package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.dto.mapper.PersonMapper;
import com.application.moviedatabase.entity.PersonEntity;
import com.application.moviedatabase.entity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        PersonEntity savedEntity = personRepository.save(entity);
        return personMapper.toDTO(savedEntity);
    }
}
