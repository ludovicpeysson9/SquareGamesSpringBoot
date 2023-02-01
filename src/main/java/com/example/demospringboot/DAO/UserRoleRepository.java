package com.example.demospringboot.DAO;

import com.example.demospringboot.models.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findByRoleName(String roleName);
}
