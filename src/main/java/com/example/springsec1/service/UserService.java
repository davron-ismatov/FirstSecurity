package com.example.springsec1.service;

import com.example.springsec1.entity.Users;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public interface UserService {
    public Set<Users> getAllUsers();
    public Users getUser(Long id);

    public Users createUser(Users users);

    public void deleteUser(Long id);
}
