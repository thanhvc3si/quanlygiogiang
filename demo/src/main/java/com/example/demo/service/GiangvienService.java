package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Giangvien;

public interface GiangvienService {
	List<Giangvien> getlistAllGiangvien();
	boolean addGiangvien(Giangvien giangvien);
	boolean editGiangvien(Giangvien giangvien);
	boolean DeleteGiangvien(Giangvien giangvien);
}
