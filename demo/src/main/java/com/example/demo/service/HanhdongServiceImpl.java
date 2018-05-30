package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HanhdongRepo;
import com.example.demo.model.Hanhdong;

@Service
public class HanhdongServiceImpl implements HanhdongService{

	@Autowired
	HanhdongRepo hanhdongRepo;
	@Override
	public Hanhdong getinfo(long id) {
		// TODO Auto-generated method stub
		return hanhdongRepo.findByIdHanhDong(id);
	}
	@Override
	public List<Hanhdong> list() {
		// TODO Auto-generated method stub
		return hanhdongRepo.findAll();
	}

}
