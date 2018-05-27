package com.example.demo.model;

public class ThongKeGioGiang {
	
	String lophoc;
	
	String tenHocPhan;
	
	String noiDungThucHien;
	
	int soLuong;
	
	double heSoQuyDoi;
	
	double tongSoGioChuan;
	
	String ghiChu;

	public String getLophoc() {
		return lophoc;
	}

	public void setLophoc(String lophoc) {
		this.lophoc = lophoc;
	}

	public String getTenHocPhan() {
		return tenHocPhan;
	}

	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
	}

	public String getNoiDungThucHien() {
		return noiDungThucHien;
	}

	public void setNoiDungThucHien(String noiDungThucHien) {
		this.noiDungThucHien = noiDungThucHien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getHeSoQuyDoi() {
		return heSoQuyDoi;
	}

	public void setHeSoQuyDoi(double heSoQuyDoi) {
		this.heSoQuyDoi = heSoQuyDoi;
	}

	public double getTongSoGioChuan() {
		return tongSoGioChuan;
	}

	public void setTongSoGioChuan(double tongSoGioChuan) {
		this.tongSoGioChuan = tongSoGioChuan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public ThongKeGioGiang(String lophoc, String tenHocPhan, String noiDungThucHien, int soLuong, double heSoQuyDoi,
			double tongSoGioChuan, String ghiChu) {
		super();
		this.lophoc = lophoc;
		this.tenHocPhan = tenHocPhan;
		this.noiDungThucHien = noiDungThucHien;
		this.soLuong = soLuong;
		this.heSoQuyDoi = heSoQuyDoi;
		this.tongSoGioChuan = tongSoGioChuan;
		this.ghiChu = ghiChu;
	}

	
	
	
}
