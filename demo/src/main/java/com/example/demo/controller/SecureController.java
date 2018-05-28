package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.UserRepositry;
import com.example.demo.model.User;

@Controller
@RequestMapping("/foo")
public class SecureController {
	@Autowired
	UserRepositry userRepository;
	
	@Transactional
    @RequestMapping(value = "/getUser",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserInfo(HttpServletRequest req) {
    	Authentication authentication = SecurityContextHolder.getContext()
    		    .getAuthentication();
    	String username = authentication == null ? "null" : authentication.getName();
    	User u = userRepository.findByUserNameCaseInsensitive(username);
    	
    	return new ResponseEntity<Object>(u, HttpStatus.OK);
    }
}
