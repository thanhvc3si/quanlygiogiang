package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.NguoiDungRepo;
import com.example.demo.model.Nguoidung;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

	@Autowired
	private NguoiDungRepo userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {

		log.debug("Authenticating {}", login);
		String lowercaseLogin = login.toLowerCase();

		Nguoidung userFromDatabase;
		userFromDatabase = userRepository.findByUserNameCaseInsensitive(lowercaseLogin);
		if (userFromDatabase == null) {
			throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
		}
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getQuyen().getTenQuyen());
            grantedAuthorities.add(grantedAuthority);

		return new org.springframework.security.core.userdetails.User(userFromDatabase.getTenDangNhap(),
				userFromDatabase.getMatKhau(), grantedAuthorities);

	}

}
