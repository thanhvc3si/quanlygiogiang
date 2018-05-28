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
		Giangvien gv = giangvienRepo.findByIdGiangVien(id);
		gv.setDinhMucGioChuan(dinhMucGioChuan(gv.getChucdanh().getMaChucDanh()));
		String cv = gv.getChucvu().getMaChucVu();
		gv.setMienGIam(mienGiam(cv));
		gv.setSoGioThucHien(gv.getDinhMucGioChuan()-(gv.getDinhMucGioChuan()*(gv.getMienGIam()/100)));
		List<ThongKeGioGiang> list = thongKeGioGiang(gv.getIdGiangVien());
		double tong = 0.00;
		for(ThongKeGioGiang tk : list)
		{
			tong += tk.getTongSoGioChuan();
		}
		double thua = 0.00;
		double thieu = 0.00;
		gv.setTong(tong);
		if((tong-gv.getSoGioThucHien()) > 0)
		{
			thua = (tong-gv.getSoGioThucHien());
			thieu = 0.00;
		}
		if((tong-gv.getSoGioThucHien()) < 0)
		{
			thieu = -(tong-gv.getSoGioThucHien());
			thua = 0.00;
		}
		gv.setThua(thua);
		gv.setThieu(thieu);
		return gv;
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
	
	private double mienGiam(String chucVu) {
		if("TK".equals(chucVu)) {
			return 25;
		}
		if("PK".equals(chucVu)) {
			return 20;
		}
		if("TT".equals(chucVu)) {
			return 10;
		}
		if("TP".equals(chucVu)) {
			return 5;
		}
		if("PBT".equals(chucVu)) {
			return 25;
		}
		if("BTD".equals(chucVu)) {
			return 25;
		}
		if("CTCD".equals(chucVu)) {
			return 25;
		}
		if("CTHPN".equals(chucVu)) {
			return 25;
		}
		if("TVDU".equals(chucVu)) {
			return 25;
		}
		if("PBTD".equals(chucVu)) {
			return 25;
		}
		if("CNL".equals(chucVu)) {
			return 30;
		}
		
		return 0;
	}
	
	private double dinhMucGioChuan(String chucdanh) {
		if("GS".equals(chucdanh)) {
			return 360;
		}
		if("PGS".equals(chucdanh)) {
			return 300;
		}
		if("GVT".equals(chucdanh)) {
			return 280;
		}
		if("Gv".equals(chucdanh)) {
			return 260;
		}
		if("TG".equals(chucdanh)) {
			return 140;
		}
		if("CCTCCN".equals(chucdanh)) {
			return 500;
		}
		if("CTCCN".equals(chucdanh)) {
			return 460;
		}
		if("TCCN".equals(chucdanh)) {
			return 430;
		}
		
		return 0;
	}
}
