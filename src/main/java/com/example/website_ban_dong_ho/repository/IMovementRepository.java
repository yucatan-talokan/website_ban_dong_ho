package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementRepository extends JpaRepository<Movement,Integer> {
}
