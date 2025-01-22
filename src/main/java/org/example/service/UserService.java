package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    List<User> getAllUsers();

}
