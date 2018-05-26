package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Giangvien;
import com.example.demo.model.Nguoidung;
import com.example.demo.service.NguoidungService;

@Controller
@RequestMapping("/user")
public class NguoidungController {
	@Autowired
	NguoidungService nguoidungService;
	@GetMapping("nguoidung-info")
	public ResponseEntity<Nguoidung> getNguoiDung() {
		Nguoidung list = nguoidungService.getnguoidung();
		return new ResponseEntity<Nguoidung>(list, HttpStatus.OK);
	}
}
