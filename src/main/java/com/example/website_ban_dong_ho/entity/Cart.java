package com.example.website_ban_dong_ho.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity = 1;
}
