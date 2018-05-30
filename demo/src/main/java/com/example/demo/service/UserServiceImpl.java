package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepositry;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
 private UserRepositry userRepository;
 @Autowired
 private RoleRepository roleRepository;

 @SuppressWarnings("unchecked")
 public void save(User user) {
 user.setPassword(user.getPassword());
 user.setRoles((roleRepository.findAll()));
 userRepository.save(user);
 }

 public User findByUsername(String username) {
 return userRepository.findByUserNameCaseInsensitive(username);
 }
}