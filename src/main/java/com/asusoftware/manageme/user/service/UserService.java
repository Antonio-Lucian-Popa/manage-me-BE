package com.asusoftware.manageme.user.service;

import com.asusoftware.manageme.exceptions.UserNotFoundException;
import com.asusoftware.manageme.user.model.User;
import com.asusoftware.manageme.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(UUID id) {
       return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }
}
