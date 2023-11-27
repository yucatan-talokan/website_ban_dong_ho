package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Category;
import com.example.website_ban_dong_ho.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        Optional<Category>result=repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Mã danh mục không tồn tại: Id = "+id);
        }
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
