package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.OrderDetail;
import com.example.website_ban_dong_ho.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository repository;

    @Override
    public void saveAll(List<OrderDetail> listOrderDetails) {
        repository.saveAll(listOrderDetails);
    }
}
