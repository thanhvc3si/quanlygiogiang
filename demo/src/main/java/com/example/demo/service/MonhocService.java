package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Monhoc;

public interface MonhocService {
	
	List<Monhoc> listAllMonhoc();
	Monhoc findMonHocInfo(String mamon);
	boolean addMonHoc(Monhoc monhoc);
	boolean editMonHoc(Monhoc monhoc);
	boolean DeleteMonHoc(Monhoc monhoc);
}
