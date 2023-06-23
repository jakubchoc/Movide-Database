package com.application.moviedatabase.service;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.dto.mapper.PersonMapper;
import com.application.moviedatabase.entity.PersonEntity;
import com.application.moviedatabase.entity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<PersonDTO> getPeople(RoleType role, int limit) {
        Page<PersonEntity> pageOfPeople = personRepository.getAllByRole(role, limit);
        List<PersonEntity> peopleEntities = pageOfPeople.getContent();

        return peopleEntities.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

}
