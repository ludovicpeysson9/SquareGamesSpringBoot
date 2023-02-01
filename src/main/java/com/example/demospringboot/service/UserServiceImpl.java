package com.example.demospringboot.service;

import com.example.demospringboot.DAO.UserRepository;
import com.example.demospringboot.DAO.UserRoleRepository;
import com.example.demospringboot.interfaces.UserService;
import com.example.demospringboot.models.UserEntity;
import com.example.demospringboot.models.UserRoleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserEntity addNewUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserRoleEntity addNewRole(UserRoleEntity userRoleEntity) {
        return userRoleRepository.save(userRoleEntity);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        UserRoleEntity userRoleEntity = userRoleRepository.findByRoleName(roleName);
        userEntity.getUserRoles().add(userRoleEntity);
    }

    @Override
    public UserEntity loadUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }
}
