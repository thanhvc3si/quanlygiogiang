package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Giangvien;
import com.example.demo.model.GiangvienDTO;
import com.example.demo.model.ThongKeGioGiang;

public interface GiangvienService {
	List<Giangvien> getlistAllGiangvien();
	Giangvien findGVbyId(long id);
	boolean addGiangvien(GiangvienDTO giangvien);
	boolean editGiangvien(GiangvienDTO giangvien);
	boolean DeleteGiangvien(Giangvien giangvien);
	boolean updateHanhDongMonHoc(GiangvienDTO giangvien);
	boolean deleteHanhDongMonHoc(GiangvienDTO giangvien);
	
	List<ThongKeGioGiang> thongKeGioGiang(long id);
}
