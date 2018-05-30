package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepositry;
import com.example.demo.model.Role;
import com.example.demo.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
 @Autowired
 private UserRepositry userRepository;

 @Transactional(readOnly = true)
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 User user = userRepository.findByUserNameCaseInsensitive(username);

 List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
 for (Role role : user.getRoles()){
 grantedAuthorities.add(new SimpleGrantedAuthority(role.getNameRole()));
 }

 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
 }
}
