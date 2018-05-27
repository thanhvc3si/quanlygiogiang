package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MonhocRepo;
import com.example.demo.model.Monhoc;

@Service
public class MonhocServiceImpl implements MonhocService{
	
	@Autowired
	MonhocRepo monhocRepo;
	@Override
	public List<Monhoc> listAllMonhoc() {
		// TODO Auto-generated method stub
		return monhocRepo.findAll();
	}

	@Override
	public boolean addMonHoc(Monhoc monhoc) {
		monhocRepo.saveAndFlush(monhoc);
		return true;
	}

	@Override
	public boolean editMonHoc(Monhoc monhoc) {
		// TODO Auto-generated method stub
		monhocRepo.save(monhoc);
		return true;
	}

	@Override
	public boolean DeleteMonHoc(Monhoc monhoc) {
		// TODO Auto-generated method stub
		monhocRepo.delete(monhoc);
		return true;
	}

	@Override
	public Monhoc findMonHocInfo(String mamon) {
		// TODO Auto-generated method stub
		return monhocRepo.findByMaMonHoc(mamon);
	}

}
