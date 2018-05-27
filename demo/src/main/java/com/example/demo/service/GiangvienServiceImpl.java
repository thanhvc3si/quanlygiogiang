package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GiangvienRepo;
import com.example.demo.model.Giangvien;
import com.example.demo.model.Hanhdong;
import com.example.demo.model.Monhoc;
import com.example.demo.model.ThongKeGioGiang;

@Service
public class GiangvienServiceImpl implements GiangvienService {

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

	@Override
	public Giangvien findGVbyId(long id) {
		// TODO Auto-generated method stub
		return giangvienRepo.findByIdGiangVien(id);
	}

	@Override
	public List<ThongKeGioGiang> thongKeGioGiang(long id) {
		// TODO Auto-generated method stub
		List<ThongKeGioGiang> list = new ArrayList<>();
		List<Hanhdong> hds = giangvienRepo.findByIdGiangVien(id).getHanhdongs();
		for (Hanhdong hd : hds) {
			for (Monhoc mh : hd.getMonhocs()) {
				ThongKeGioGiang tkgg = new ThongKeGioGiang(mh.getTenLop(), mh.getTenMonHoc(), hd.getTenHanhDong(),
						mh.getSoTiet(), tinhHeSoQuyDoi(mh.getSiSo(), hd.getMaHanhDong()),
						tongSoGioChuan(mh.getSoTiet(), tinhHeSoQuyDoi(mh.getSiSo(), hd.getMaHanhDong())), " ");
				list.add(tkgg);
			}
		}
		return list;
	}

	private double tinhHeSoQuyDoi(int siSo, String maHanhDong) {
		if (("RDTL").equals(maHanhDong)) {
			return 1;
		}
		if (("RDTN").equals(maHanhDong)) {
			return 1 / 10;
		}
		if (("RDVD").equals(maHanhDong)) {
			return 1 / 8;
		}
		if (("CTTL").equals(maHanhDong)) {
			return 1 / 8;
		}
		if (("CTVD").equals(maHanhDong)) {
			return 1 / 10;
		}
		if (("CTTH").equals(maHanhDong)) {
			return 1 / 10;
		}
		if (("CTTN").equals(maHanhDong)) {
			return 1 / 20;
		}
		if (("DTH").equals(maHanhDong)) {
			return 1;
		}
		if (("DLT").equals(maHanhDong)) {
			if (siSo < 50) {
				return 1;
			}
			if (siSo >= 50) {
				return 1.2;
			}
			if (siSo >= 100) {
				return 1.4;
			}
		}
		return 0;
	}

	private double tongSoGioChuan(int soTiet, double heSo) {
		return soTiet * heSo;
	}
}
