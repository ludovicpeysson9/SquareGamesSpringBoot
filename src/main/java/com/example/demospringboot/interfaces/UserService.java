package com.example.demospringboot.interfaces;

import com.example.demospringboot.models.entity.UserEntity;
import com.example.demospringboot.models.entity.UserRoleEntity;

import java.util.List;

public interface UserService {

    UserEntity addNewUser (UserEntity userEntity);
    UserRoleEntity addNewRole (UserRoleEntity userRoleEntity);
    void addRoleToUser (String userName, String roleName);
    UserEntity loadUserByUserName(String userName);
    List<UserEntity> listUsers();
}
