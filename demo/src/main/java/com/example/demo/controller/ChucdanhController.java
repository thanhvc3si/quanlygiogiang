package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Chucdanh;
import com.example.demo.service.ChucdanhService;

@Controller
@RequestMapping("/chucdanh")
public class ChucdanhController {

	@Autowired
	ChucdanhService chucdanhService;
	
	@GetMapping("list-chucdanh")
	public ResponseEntity<List<Chucdanh>> getListMonhoc() {
		List<Chucdanh> list = chucdanhService.getListChucdanh();
		return new ResponseEntity<List<Chucdanh>>(list, HttpStatus.OK);
	}
}
