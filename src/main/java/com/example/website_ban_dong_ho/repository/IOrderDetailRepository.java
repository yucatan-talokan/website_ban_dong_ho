package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
