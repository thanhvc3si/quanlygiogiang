package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChucdanhRepo;
import com.example.demo.model.Chucdanh;

@Service
public class ChucdanhServiceImpl implements ChucdanhService {

	@Autowired
	ChucdanhRepo chucdanhRepo;
	@Override
	public List<Chucdanh> getListChucdanh() {
		// TODO Auto-generated method stub
		return chucdanhRepo.findAll();
	}

}
