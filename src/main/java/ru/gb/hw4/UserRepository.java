package ru.gb.hw4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Daniel", "Löble@gmail.com", 51));
        users.add(new User("Sascha", "Gerstner@gmail.com", 47));
        users.add(new User("Andi", "Deris@gmail.com", 60));
        users.add(new User("Michael", "Kiske@gmail.com", 56));
        users.add(new User("Kai", "Hansen@gmail.com", 61));
        users.add(new User("Markus", "Grosskopf@gmail.com", 59));
        users.add(new User("Michael", "Weikath@gmail.com", 62));
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