package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from Product p where p.category.id=:id")
    List<Product> findByCategoryId(@Param("id")Integer id);
}
