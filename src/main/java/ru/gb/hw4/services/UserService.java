package ru.gb.hw4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hw4.User;
import ru.gb.hw4.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    @Autowired
    public UserService(UserRepository userRepository, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public User createUser(String name, String email, Integer age) {
        User found = userRepository.getByEmail(email);
        if (found != null) {
            notificationService.error("User with email " + email + " already exists");
            return null;
        }
        found = userRepository.getByName(name);
        if (found != null) {
            notificationService.error("User with name " + name + " already exists");
            return null;
        }
        User user = new User(name, email, age);
        notificationService.notify("User " + name + " has been created");
        return userRepository.addUser(user);
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.update(user);
        if (updatedUser != null) {
            notificationService.notify("User " + updatedUser.getName() + " has been updated");
            return updatedUser;
        }
        notificationService.error("User with name " + user.getName() + " not found");
        return null;
    }

    public List<User> getAllUsers() {
        notificationService.notify("Get all users");
        return userRepository.getAllUsers();
    }

    public List<User> getSortedUsers(String field) {
        switch (field) {
            case "name" -> {
                notificationService.notify("Get sorted users by names");
                return dataProcessingService.sortByName();
            }
            case "email" -> {
                notificationService.notify("Get sorted users by email");
                return dataProcessingService.sortByEmail();
            }
            case "age" -> {
                notificationService.notify("Get sorted users by age");
                return dataProcessingService.sortByAge();
            }
            default -> {
                notificationService.error("Unknown field: " + field);
                notificationService.notify("Get sorted users by names");
                return dataProcessingService.sortByName();
            }
        }
    }

    public boolean deleteUser(Integer id) {
        boolean deletedUser = userRepository.delete(id);
        if (deletedUser) {
            notificationService.notify("User " + id + " has been deleted");
            return true;
        }
        notificationService.error("User with id " + id + " not found");
        return false;
    }

    public List<User> filterByAge(Integer age) {
        notificationService.notify("Filtered by age " + age);
        return dataProcessingService.filterByAge(age);
    }
}