package com.itstep.diploma.controller;

import com.itstep.diploma.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";

    }
}
