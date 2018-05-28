package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepositry extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	User findByUserNameCaseInsensitive(@Param("username") String username);
}
