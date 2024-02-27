package com.example.springsec1.service.impl;

import com.example.springsec1.entity.Users;
import com.example.springsec1.repository.UserRepository;
import com.example.springsec1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public Set<Users> getAllUsers() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Users getUser(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Users createUser(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return repository.save(users);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
