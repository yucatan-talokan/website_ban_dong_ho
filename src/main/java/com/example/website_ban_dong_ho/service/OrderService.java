package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Order;
import com.example.website_ban_dong_ho.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository repository;

    @Override
    public List<Order> findAllDesc() {
        return repository.findAllDesc();
    }

    @Override
    public Page<Order> findPageDesc(Pageable pageable) {
        return repository.findPageDesc(pageable);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public Order findById(Integer id) {
        Optional<Order> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException("Mã hoá đơn này không tồn tại: Id = " + id);
    }


}
