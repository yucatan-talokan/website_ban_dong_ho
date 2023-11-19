package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Cart;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ICartRepository {
    void add(Cart cart);

    void remove(Integer id);

    Cart update(Integer id,Integer quantity);

    void deleteAll();

    Collection<Cart>getAll();

    Integer getTotalQuantity();

    BigDecimal getTotalPrice();

}
