package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.UserRepositry;
import com.example.demo.model.Giangvien;
import com.example.demo.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserRepositry userRepositry;

	@RequestMapping(path="/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getListGiangvien() {
		List<User> list = userRepositry.findAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@RequestMapping(path="/user", method = RequestMethod.POST)
	public ResponseEntity  listUser(@RequestBody User user){
		return new ResponseEntity("18", HttpStatus.OK);
	}
}