package com.itstep.diploma.controller;

import com.itstep.diploma.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam Long user_id,
                             @RequestParam String action, Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(user_id);
        }
        return "admin";
    }
    @GetMapping("/admin/gt/{user_id}")
    public String gtUser(@PathVariable("user_id") Long user_id, Model model){
        model.addAttribute("allUsers", userService.usergtList(user_id));
        return "admin";
    }
}

