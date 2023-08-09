package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    List<Product>findByCategoryId(Integer id);

    Product findById(Integer id);

    void save(Product product);

    void delete(Integer id);
}
