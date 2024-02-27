package com.example.springsec1.service;

import com.example.springsec1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUsersService implements UserDetailsService {
    private final UserRepository repository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.getUsersByUsername(username);
    }
}
