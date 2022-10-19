package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    public EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getEmail(String email) {
        return entityManager.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public void edit(long id, User user) {
        User userSet = getUser(id);
        userSet.setFirstName(user.getFirstName());
        userSet.setLastName(user.getLastName());
        userSet.setAge(user.getAge());
        userSet.setEmail(user.getEmail());
        userSet.setUserPassword(user.getUserPassword());
        userSet.setRoles(user.getRoles());
        entityManager.merge(userSet);
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
