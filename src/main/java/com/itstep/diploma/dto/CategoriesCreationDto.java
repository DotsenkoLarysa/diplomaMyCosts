package com.itstep.diploma.dto;

import com.itstep.diploma.model.Category;

import java.util.List;

public class CategoriesCreationDto {
    private List<Category> categoryList;

    public CategoriesCreationDto(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoriesCreationDto() {
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void addCategory(Category category) {
        if (category == null) {
            this.categoryList = null;
        } else {
            this.categoryList.add(category);
        }
    }
}
