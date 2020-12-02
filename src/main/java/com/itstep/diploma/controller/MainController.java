package com.itstep.diploma.controller;

import com.itstep.diploma.service.JournalService;
import com.itstep.diploma.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    private final UserService userService;
    private final JournalService journalService;

    public MainController(UserService userService, JournalService journalService) {
        this.userService = userService;
        this.journalService = journalService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/index";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("listJournals", journalService.listAll());
        return "/about";
    }

}

