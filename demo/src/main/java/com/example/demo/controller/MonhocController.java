package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.Monhoc;
import com.example.demo.service.MonhocService;
import com.example.demo.untils.Constants;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/monhoc")
public class MonhocController {
	
	@Autowired
	MonhocService monhocService;
	
	@GetMapping("list-monhoc")
	public ResponseEntity<List<Monhoc>> getListMonhoc() {
		List<Monhoc> list = monhocService.listAllMonhoc();
		return new ResponseEntity<List<Monhoc>>(list, HttpStatus.OK);
	}
	
	@GetMapping("monhoc-info/{id}")
	public ResponseEntity<Monhoc> monhocInfo(@PathVariable("id") long id) {
		Monhoc stUserInfo = monhocService.findMonHocInfo(id);
		return new ResponseEntity<Monhoc>(stUserInfo, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<BaseResponse> addMonhoc(@Validated Monhoc monhoc, BindingResult result) {
		boolean flag = monhocService.addMonHoc(monhoc);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<BaseResponse> editMonhoc(@Validated Monhoc monhoc, BindingResult result) {
		boolean flag = monhocService.editMonHoc(monhoc);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
	

	@PostMapping("delete")
	public ResponseEntity<BaseResponse> deleteMonhoc( @Validated Monhoc monhoc, BindingResult result) {
		boolean flag = monhocService.DeleteMonHoc(monhoc);
		if(flag) {
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(Constants.RESPONSE.SUCCESS_STATUS,
				Constants.RESPONSE.SUCCESS_CODE, Constants.RESPONSE.SUCCESS_MESSAGE), HttpStatus.OK);
	}
}
