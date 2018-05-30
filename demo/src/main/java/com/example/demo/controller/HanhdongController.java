package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Giangvien;
import com.example.demo.model.Hanhdong;
import com.example.demo.service.HanhdongService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/hanhdong")
public class HanhdongController {
	
	@Autowired
	HanhdongService hanhdongService;
	
	@GetMapping("list-hanhdong")
	public ResponseEntity<List<Hanhdong>> getListhanhdong() {
		List<Hanhdong> list = hanhdongService.list();
		return new ResponseEntity<List<Hanhdong>>(list, HttpStatus.OK);
	}

}
