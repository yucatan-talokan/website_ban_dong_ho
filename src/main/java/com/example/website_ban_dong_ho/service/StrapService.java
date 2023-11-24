package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Strap;
import com.example.website_ban_dong_ho.repository.IStrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrapService implements IStrapService{
    @Autowired
    private IStrapRepository repository;

    @Override
    public List<Strap> findAll() {
        return repository.findAll();
    }

    @Override
    public Strap findById(Integer id) {
        Optional<Strap>result=repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Mã dây không tồn tại: Id = "+id);
        }
    }


}
