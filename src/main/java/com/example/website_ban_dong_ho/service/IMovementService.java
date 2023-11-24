package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Movement;

import java.util.List;

public interface IMovementService {
    List<Movement>findAll();

    Movement findById(Integer id);
}
