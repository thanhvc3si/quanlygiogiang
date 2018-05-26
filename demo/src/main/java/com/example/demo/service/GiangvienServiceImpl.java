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
	@Override
	public boolean addGiangvien(Giangvien giangvien) {
		// TODO Auto-generated method stub
		giangvienRepo.saveAndFlush(giangvien);
		return true;
	}
	@Override
	public boolean editGiangvien(Giangvien giangvien) {
		// TODO Auto-generated method stub
		giangvienRepo.save(giangvien);
		return true;
	}
	@Override
	public boolean DeleteGiangvien(Giangvien giangvien) {
		// TODO Auto-generated method stub
		giangvienRepo.delete(giangvien);
		return true;
	}

}
