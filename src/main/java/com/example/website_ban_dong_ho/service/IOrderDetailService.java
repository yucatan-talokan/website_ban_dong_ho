package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    void saveAll(List<OrderDetail>listOrderDetails);
}
