package ru.gb.hw4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hw4.User;
import ru.gb.hw4.UserRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class DataProcessingService {
    private final UserRepository userRepository;

    @Autowired
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> sortByName() {
        return userRepository.getAllUsers().stream().sorted(Comparator.comparing(User::getName)).toList();
    }

    public List<User> sortByEmail() {
        return userRepository.getAllUsers().stream().sorted(Comparator.comparing(User::getEmail)).toList();
    }

    public List<User> sortByAge() {
        return userRepository.getAllUsers().stream().sorted(Comparator.comparing(User::getAge)).toList();
    }

    public List<User> filterByAge(Integer age) {
        return userRepository.getAllUsers().stream().filter(u -> u.getAge() >= age).toList();
    }
}