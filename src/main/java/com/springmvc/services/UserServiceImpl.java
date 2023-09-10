package com.springmvc.services;

import com.springmvc.dao.UserDao;
import com.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
