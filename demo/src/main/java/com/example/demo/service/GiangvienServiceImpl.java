package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GiangvienRepo;
import com.example.demo.model.Giangvien;

@Service
public class GiangvienServiceImpl implements GiangvienService{
	
	@Autowired
	GiangvienRepo giangvienRepo;
	@Override
	public List<Giangvien> getlistAllGiangvien() {
		// TODO Auto-generated method stub
		return giangvienRepo.findAll();
	}

}
