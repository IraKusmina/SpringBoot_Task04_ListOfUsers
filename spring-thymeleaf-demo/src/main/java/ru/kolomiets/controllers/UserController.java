package ru.kolomiets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kolomiets.models.User;
import ru.kolomiets.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String mainPage(){
        return "main";
    }
    @GetMapping("users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @PostMapping("create")
    public String registerUser (@ModelAttribute User user) {
        userService.saveUser(user);
        return "success"; // Переход на страницу успешной регистрации
    }

    @GetMapping("create")
    public String createUser (Model model) {
        model.addAttribute("user", new User()); // Добавляем пустой объект User в модель
        return "create"; // Переход на страницу создания пользователя
    }

}
