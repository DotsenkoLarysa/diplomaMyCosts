package com.itstep.diploma.controller;

import com.itstep.diploma.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/allShow")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "about";
    }

}
