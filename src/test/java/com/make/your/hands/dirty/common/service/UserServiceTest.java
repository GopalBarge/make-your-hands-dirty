package com.make.your.hands.dirty.common.service;

import com.make.your.hands.dirty.common.entity.User;
import com.make.your.hands.dirty.common.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    private UserService userService;

    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserService(userRepositoryMock);
    }

    @Test
    void getAllUsersShouldReturnAllUsers() {
        List<User> expectedUsers = new ArrayList<>();
        when(userRepositoryMock.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.getAllUsers();

        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void getUserByIdShouldReturnUserIfExists() {
        long userId = 1L;
        User expectedUser = new User(userId, "John Doe", "john@example.com");
        when(userRepositoryMock.findById(userId)).thenReturn(Optional.of(expectedUser));

        Optional<User> actualUser = userService.getUserById(userId);

        assertTrue(actualUser.isPresent());
        assertEquals(expectedUser, actualUser.get());
    }

    @Test
    void getUserByIdShouldReturnEmptyOptionalForNonExistingUser() {
        long nonExistingUserId = 100L;
        when(userRepositoryMock.findById(nonExistingUserId)).thenReturn(Optional.empty());

        Optional<User> actualUser = userService.getUserById(nonExistingUserId);

        assertTrue(actualUser.isEmpty());
    }

    @Test
    void saveUserShouldReturnSavedUser() {
        User userToSave = new User(null, "Jane Doe", "jane@example.com");
        User savedUser = new User(1L, "Jane Doe", "jane@example.com");

        when(userRepositoryMock.save(userToSave)).thenReturn(savedUser);

        User actualSavedUser = userService.saveUser(userToSave);

        assertEquals(savedUser, actualSavedUser);
    }

    @Test
    void deleteUserShouldInvokeRepositoryDeleteById() {
        long userIdToDelete = 1L;

        userService.deleteUser(userIdToDelete);

        verify(userRepositoryMock, times(1)).deleteById(userIdToDelete);
    }
}
