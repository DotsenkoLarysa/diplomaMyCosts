package com.itstep.diploma.service;

import com.itstep.diploma.model.Category;
import com.itstep.diploma.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        this.categoryRepository.save(category);
    }


    public Category get(int id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()) {
           return optional.get();
        } else {
            throw new RuntimeException("Category not found for id :: " + id);
        }
    }

    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }
}
