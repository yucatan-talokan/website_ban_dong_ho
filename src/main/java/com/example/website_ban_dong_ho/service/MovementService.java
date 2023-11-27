package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Movement;
import com.example.website_ban_dong_ho.repository.IMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService implements IMovementService{
    @Autowired
    private IMovementRepository repository;

    @Override
    public List<Movement> findAll() {
        return repository.findAll();
    }

    @Override
    public Movement findById(Integer id) {
        Optional<Movement>result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else {
            throw new RuntimeException("Mã hãng không tồn tại: Id = "+id);
        }
    }

    @Override
    public void save(Movement movement) {
        repository.save(movement);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
