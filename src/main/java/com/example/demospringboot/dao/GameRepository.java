package com.example.demospringboot.dao;

import com.example.demospringboot.models.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GameRepository extends CrudRepository<GameEntity, Integer> {
    List<GameEntity> findAll();

}
