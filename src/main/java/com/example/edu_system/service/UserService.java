package com.example.edu_system.service;

import com.example.edu_system.domain.User;
import com.example.edu_system.mapper.UserMapper;
import com.example.edu_system.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.findAll()
        .stream().map(UserMapper::map)
        .collect(Collectors.toList());
  }

  public User saveUser(User user) {
    final var savedEntity = userRepository.save(
        UserMapper.map(user)
    );
    return UserMapper.map(savedEntity);

  }
}
