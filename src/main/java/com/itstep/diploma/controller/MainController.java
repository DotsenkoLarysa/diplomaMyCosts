package com.itstep.diploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    public MainController() {
        super();
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @RequestMapping("/add_user")
    public String addUser() {
        return "/add_user";
    }

    @RequestMapping("/update_user")
    public String updateUser() {
        return "/update_user";
    }

}

