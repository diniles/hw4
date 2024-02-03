package ru.gb.hw4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.hw4.services.UserService;

@Controller
@RequestMapping("/")
public class UserViewController {
    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }
}
