package com.example.springsec1.repository;

import com.example.springsec1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsernameIgnoreCase(String username);
    Users getUsersByUsername(String username);
    boolean existsByUsernameIgnoreCase(String username);
}
