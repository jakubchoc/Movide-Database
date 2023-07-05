package com.application.moviedatabase.service;

import com.application.moviedatabase.controller.advice.DuplicateEmailException;
import com.application.moviedatabase.dto.UserDTO;
import com.application.moviedatabase.dto.mapper.UserMapper;
import com.application.moviedatabase.entity.UserEntity;
import com.application.moviedatabase.entity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO create(UserDTO userDTO) {
        UserEntity userEntity = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
        if (userEntity != null) {
            throw new DuplicateEmailException();
        }

        UserEntity newEntity = new UserEntity();
        newEntity.setEmail(userDTO.getEmail());
        newEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newEntity = userRepository.save(newEntity);

        UserDTO dto = new UserDTO();
        dto.setUserId(newEntity.getUserId());
        dto.setEmail(newEntity.getEmail());
        userRepository.save(newEntity);

        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}
