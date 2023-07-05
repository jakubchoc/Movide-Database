package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDTO create(UserDTO userDTO);
}
