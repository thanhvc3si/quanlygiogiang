package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PhongbanRepo;
import com.example.demo.model.Phongban;

@Service
public class PhongbanServiceImpl implements PhongbanService{
	
	@Autowired
	PhongbanRepo phongbanRepo;
	@Override
	public List<Phongban> getListPhongban() {
		// TODO Auto-generated method stub
		return phongbanRepo.findAll();
	}

}
