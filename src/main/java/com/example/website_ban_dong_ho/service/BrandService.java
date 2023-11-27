package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Brand;
import com.example.website_ban_dong_ho.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository repository;

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        Optional<Brand>result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Mã hãng không tồn tại: Id = "+id);
        }
    }

    @Override
    public void save(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
