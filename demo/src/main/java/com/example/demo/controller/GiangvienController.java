package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.Giangvien;
import com.example.demo.model.Monhoc;
import com.example.demo.service.GiangvienService;
import com.example.demo.untils.Constants;

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
	
	@PostMapping("add")
	public ResponseEntity<BaseResponse> addMonhoc(@RequestBody @Validated Giangvien giangvien, BindingResult result) {
		boolean flag = giangvienService.addGiangvien(giangvien);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<BaseResponse> editMonhoc(@RequestBody @Validated Giangvien giangvien, BindingResult result) {
		boolean flag = giangvienService.editGiangvien(giangvien);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
	

	@PostMapping("delete")
	public ResponseEntity<BaseResponse> deleteMonhoc(@RequestBody @Validated Giangvien giangvien, BindingResult result) {
		boolean flag = giangvienService.DeleteGiangvien(giangvien);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
}
