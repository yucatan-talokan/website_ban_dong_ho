package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByCategoryId(Integer id) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> result = repository.findById(id);
        Product product = null;
        if (result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Mã sản phẩm không tồn tại: Id = "+id);
        }

    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}