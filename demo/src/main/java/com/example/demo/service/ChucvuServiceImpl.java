package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChucvuRepo;
import com.example.demo.model.Chucvu;

@Service
public class ChucvuServiceImpl implements ChucvuService{

	@Autowired
	ChucvuRepo chucvuRepo;
	@Override
	public List<Chucvu> getListChucvu() {
		// TODO Auto-generated method stub
		return chucvuRepo.findAll();
	}

}
