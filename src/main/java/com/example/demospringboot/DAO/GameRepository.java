package com.example.demospringboot.DAO;

import com.example.demospringboot.models.GameEntity;
import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<GameEntity, Integer> {


}
