package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUserByUsername(String email);

    void saveUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
