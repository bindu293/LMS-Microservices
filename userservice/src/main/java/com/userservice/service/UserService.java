package com.userservice.service;

import com.userservice.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);
    UserDTO getUser(Long id);
    List<UserDTO> getAllUsers();
}
