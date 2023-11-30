package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    List<Order>findAllDesc();

    Page<Order>findPageDesc(Pageable pageable);

    void save(Order order);

    Order findById(Integer id);

}
