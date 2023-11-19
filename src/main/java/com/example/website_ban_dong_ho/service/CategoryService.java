package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Category;
import com.example.website_ban_dong_ho.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
