package com.askme.askme.service;

import com.askme.askme.models.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category c);
    List<Category> findAll();
    Category findById(Long id);
}
