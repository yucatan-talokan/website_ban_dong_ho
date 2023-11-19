package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> findPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Product> findByCategoryId(Integer id) {
        return repository.findByCategoryId(id);
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> result = repository.findById(id);
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