package com.springmvc.dao;

import com.springmvc.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao
{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void updateUser(int id, User user) {
        User user1 = entityManager.find(User.class, id);
        if (user1 != null) {
            user1.setEmail(user.getEmail());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            entityManager.merge(user);

        }
    }

    @Override
    public void deleteUser(int id) {
        User person = entityManager.find(User.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
