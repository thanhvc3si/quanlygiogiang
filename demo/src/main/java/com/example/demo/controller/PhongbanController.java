package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Phongban;
import com.example.demo.service.PhongbanService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/phongban")
public class PhongbanController {
	
	@Autowired
	PhongbanService phongbanService;
	
	@GetMapping("list-phongban")
	public ResponseEntity<List<Phongban>> getListMonhoc() {
		List<Phongban> list = phongbanService.getListPhongban();
		return new ResponseEntity<List<Phongban>>(list, HttpStatus.OK);
	}
}
