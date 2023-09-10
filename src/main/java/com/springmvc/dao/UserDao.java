package com.springmvc.dao;

import com.springmvc.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User getUser(int id);
    List<User> getUsers();
    void updateUser(int id, User user);
    void deleteUser(int id);
}
