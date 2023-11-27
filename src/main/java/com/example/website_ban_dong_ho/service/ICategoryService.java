package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category>findAll();

    Category findById(Integer id);

    void save(Category category);

    void delete(Integer id);
}
