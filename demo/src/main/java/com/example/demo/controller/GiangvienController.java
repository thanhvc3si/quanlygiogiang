package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Giangvien;
import com.example.demo.service.GiangvienService;

@Controller
@RequestMapping("/giangvien")
public class GiangvienController {
	@Autowired
	GiangvienService giangvienService;
	
	@GetMapping("list-giangvien")
	public ResponseEntity<List<Giangvien>> getListGiangvien() {
		List<Giangvien> list = giangvienService.getlistAllGiangvien();
		return new ResponseEntity<List<Giangvien>>(list, HttpStatus.OK);
	}
}
