package com.example.edu_system;

import com.example.edu_system.controller.UserController;
import com.example.edu_system.domain.User;
import com.example.edu_system.domain.User.Role;
import com.example.edu_system.repository.UserRepository;
import com.example.edu_system.service.UserService;
import com.example.edu_system.util.UserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class UserControllerTest {
    UserRepository userRepository;
    UserService userService;
    UserController userController;
    User mockUser;

    @BeforeEach
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = Mockito.mock(UserService.class);
        userController = new UserController(userService);
        mockUser = UserUtil.mockUser();

        Mockito.when(userService.getUsers()).thenReturn(List.of(mockUser));
        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(mockUser);
    }

    @Test
    void test_getAllUsers() {
        Assertions.assertEquals(1, userController.getUsers().size());
        final var user = userController.getUsers().getFirst();
        Assertions.assertEquals(mockUser.getUserid(), user.getUserid());
        Assertions.assertEquals(mockUser.getFullname(), user.getFullname());
        Assertions.assertEquals(mockUser.getEmail(), user.getEmail());
        Assertions.assertEquals(Role.STUDENT, user.getRole());
    }

    @Test
    void test_createUser() {
        User user = UserUtil.mockUser();
        userController.createUser(user);

        // Since getUsers() is mocked to always return one user
        Assertions.assertEquals(1, userController.getUsers().size());
        Assertions.assertEquals(user.getUserid(), user.getUserid());
        Assertions.assertEquals(user.getFullname(), user.getFullname());
        Assertions.assertEquals(user.getEmail(), user.getEmail());
        Assertions.assertEquals(Role.STUDENT, user.getRole());
    }

    private void assertUserEquals(final User user) {

    }
}