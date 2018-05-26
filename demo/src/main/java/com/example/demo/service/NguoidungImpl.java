package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NguoiDungRepo;
import com.example.demo.model.Nguoidung;

@Service
public class NguoidungImpl implements NguoidungService{

	@Autowired
	NguoiDungRepo nguoiDungRepo;
	@Override
	public Nguoidung getnguoidung() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext()
    		    .getAuthentication();
    	String username = authentication == null ? "null" : authentication.getName();
    	Nguoidung u = nguoiDungRepo.findByUserNameCaseInsensitive(username);
		return u;
	}

}
