package com.example.edu_system.controller;

import static com.example.edu_system.util.UserUtil.mockUser;

import com.example.edu_system.domain.User;
import com.example.edu_system.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public User createUser(@RequestBody final User user) {

    return userService.saveUser(user);
  }



}
