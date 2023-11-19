package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository repository;

    @Override
    public void add(Cart cart) {
        repository.add(cart);
    }

    @Override
    public void remove(Integer id) {
        repository.remove(id);
    }

    @Override
    public Cart update(Integer id, Integer quantity) {
        return repository.update(id, quantity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Collection<Cart> getAll() {
        return repository.getAll();
    }

    @Override
    public Integer getTotalQuantity() {
        return repository.getTotalQuantity();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return repository.getTotalPrice();
    }


}
