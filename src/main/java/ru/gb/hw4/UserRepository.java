package ru.gb.hw4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("user1", "user1@gmail.com", 21));
        users.add(new User("user2", "user2@gmail.com", 22));
        users.add(new User("user3", "user3@gmail.com", 23));
        users.add(new User("user4", "user4@gmail.com", 24));
        users.add(new User("user5", "user5@gmail.com", 25));
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getById(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public User getByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

    public User getByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User update(User user) {
        User userToUpdate = getById(user.getId());
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setAge(user.getAge());
            return userToUpdate;
        }
        return null;
    }

    public boolean delete(Integer id) {
        return users.removeIf(u -> u.getId() == id);
    }

}