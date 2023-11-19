package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
