package com.example.demospringboot.service;

import com.example.demospringboot.DAO.UserRepository;
import com.example.demospringboot.models.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
//    private UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.userRoleRepository = userRoleRepository;
    }
//
//    @Override
//    public UserEntity addNewUser(UserEntity userEntity) {
//        return userRepository.save(userEntity);
//    }
//
//    @Override
//    public UserRoleEntity addNewRole(UserRoleEntity userRoleEntity) {
//        return userRoleRepository.save(userRoleEntity);
//    }
//
//    @Override
//    public void addRoleToUser(String userName, String roleName) {
//        UserEntity userEntity = userRepository.findByUserName(userName);
//        UserRoleEntity userRoleEntity = userRoleRepository.findByRoleName(roleName);
//        userEntity.getUserRoles().add(userRoleEntity);
//    }
//
    @Override
    public UserEntity loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
//    @Override
//    public List<UserEntity> listUsers() {
//        return userRepository.findAll();
//    }
}
