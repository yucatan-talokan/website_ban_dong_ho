package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Page<Product>findPage(Pageable pageable);

    List<Product>findByCategoryId(Integer id);

    Product findById(Integer id);

    void save(Product product);

    void delete(Integer id) throws IOException;

}
