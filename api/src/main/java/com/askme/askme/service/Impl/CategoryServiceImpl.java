package com.askme.askme.service.Impl;

import com.askme.askme.exceptions.CategoryNotFoundException;
import com.askme.askme.models.Category;
import com.askme.askme.repository.jpa.JpaCategoryRepository;
import com.askme.askme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private JpaCategoryRepository categoryRepository;

    @Override
    public Category save(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id){
        Optional<Category> c = categoryRepository.findById(id);
        if(!c.isPresent()){
            throw new CategoryNotFoundException();
        }
        return c.get();
    }
}
