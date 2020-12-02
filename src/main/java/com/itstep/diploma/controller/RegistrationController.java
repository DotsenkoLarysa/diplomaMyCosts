package com.itstep.diploma.controller;

import com.itstep.diploma.model.User;
import com.itstep.diploma.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        } else if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Користувач з таким ім`ям вже існує");
            return "registration";
        }
        return "login";
    }
}
