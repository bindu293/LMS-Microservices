package com.userservice.service.impl;

import com.userservice.dto.UserDTO;
import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setMembershipType(dto.getMembershipType());
        user = repo.save(user);
        dto.setId(user.getId());
        return dto;
    }

    @Override
    public UserDTO getUser(Long id) {
        User u = repo.findById(id).orElseThrow();
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setEmail(u.getEmail());
        dto.setMembershipType(u.getMembershipType());
        return dto;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repo.findAll().stream().map(u -> {
            UserDTO d = new UserDTO();
            d.setId(u.getId());
            d.setName(u.getName());
            d.setEmail(u.getEmail());
            d.setMembershipType(u.getMembershipType());
            return d;
        }).collect(Collectors.toList());
    }
}
