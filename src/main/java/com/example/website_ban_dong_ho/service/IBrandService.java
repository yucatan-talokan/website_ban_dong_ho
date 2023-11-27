package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand>findAll();

    Brand findById(Integer id);

    void save(Brand brand);

    void delete(Integer id);
}
