package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Chucvu;
import com.example.demo.service.ChucvuService;

@Controller
@RequestMapping("/chucvu")
public class ChucvuController {

	@Autowired
	ChucvuService chucvuService;
	
	@GetMapping("list-chucvu")
	public ResponseEntity<List<Chucvu>> getListMonhoc() {
		List<Chucvu> list = chucvuService.getListChucvu();
		return new ResponseEntity<List<Chucvu>>(list, HttpStatus.OK);
	}
}
