package com.example.demospringboot.DAO;

import com.example.demospringboot.models.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepository extends CrudRepository<GameEntity, Integer> {
    List<GameEntity> findAll();

}
