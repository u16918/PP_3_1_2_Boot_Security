package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void create(User user);
    User getUser(long id);
    User getEmail(String email);
    void edit(long id, User user);
    void delete(long id);
}
