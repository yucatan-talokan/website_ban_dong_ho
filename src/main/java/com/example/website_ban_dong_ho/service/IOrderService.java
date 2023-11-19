package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order>findAllDesc();

    void save(Order order);

    Order findById(Integer id);
}
