package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o order by o.id desc")
    List<Order> findAllDesc();
}
