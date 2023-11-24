package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Strap;

import java.util.List;

public interface IStrapService {
    List<Strap>findAll();

    Strap findById(Integer id);
}
