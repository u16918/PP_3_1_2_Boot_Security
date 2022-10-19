package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void create(User user);
    User getUser(long id);
    User getEmail(String email);

    void edit(long id, User user);
    void delete(long id);
}

