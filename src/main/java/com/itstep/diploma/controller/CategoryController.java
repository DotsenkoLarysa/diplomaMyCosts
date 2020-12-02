package com.itstep.diploma.controller;

import com.itstep.diploma.model.Category;
import com.itstep.diploma.service.CategoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("categories", categoryService.listAll());
        return "category";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        categoryService.get(category.getCategory_id());
        if (result.hasErrors()) {
            return "redirect:/categories/all";
        }
        categoryService.save(category);
        return "redirect:/categories/all";
    }

    @GetMapping("/edit/{category_id}")
    public String showEditCategory(Model model, @PathVariable int category_id) {
        model.addAttribute("categories", categoryService.get(category_id));
        return "edit_category";
    }

}
