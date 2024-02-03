package ru.gb.hw4.services;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationService {
    Logger logger = Logger.getLogger("Notification");

    public void notify(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.severe(message);
    }
}