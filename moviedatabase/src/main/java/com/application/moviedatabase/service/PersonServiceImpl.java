package com.application.moviedatabase.service;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.dto.mapper.PersonMapper;
import com.application.moviedatabase.entity.PersonEntity;
import com.application.moviedatabase.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        PersonEntity savedEntity = personRepository.save(entity);
        return personMapper.toDTO(savedEntity);
    }

    @Override
    public List<PersonDTO> getPeople(RoleType roleType, int limit) {
        Page<PersonEntity> pageOfPeople = personRepository.getAllByRole(roleType, PageRequest.of(0, limit));
        List<PersonEntity> personEntities = pageOfPeople.getContent();

        return personEntities.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPerson(Long personId) {
        PersonEntity person = personRepository.getReferenceById(personId);
        return personMapper.toDTO(person);
    }

    @Override
    public PersonDTO editPerson(Long personId, PersonDTO personDTO) {
        if (!personRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + " not found");
        }
        PersonEntity entity = personMapper.toEntity(personDTO);
        entity.setId(personId);
        PersonEntity saved = personRepository.save(entity);
        return  personMapper.toDTO(saved);
    }

    @Override
    public PersonDTO removePerson(Long personId) {
        PersonEntity person = personRepository.findById(personId).orElseThrow(EntityNotFoundException::new);
        PersonDTO model = personMapper.toDTO(person);
        personRepository.delete(person);
        return model;
    }

}
