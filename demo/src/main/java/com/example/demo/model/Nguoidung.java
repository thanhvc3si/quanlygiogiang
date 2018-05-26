package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nguoidung database table.
 * 
 */
@Entity
@NamedQuery(name="Nguoidung.findAll", query="SELECT n FROM Nguoidung n")
public class Nguoidung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NGUOIDUNG_IDNGUOIDUNG_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NGUOIDUNG_IDNGUOIDUNG_GENERATOR")
	@Column(name="id_nguoi_dung")
	private long idNguoiDung;

	@Column(name="mat_khau")
	private String matKhau;

	@Column(name="ten_dang_nhap")
	private String tenDangNhap;

	@Column(name="ten_nguoi_dung")
	private String tenNguoiDung;

	//bi-directional many-to-one association to Quyen
	@ManyToOne
	@JoinColumn(name="id_quyen")
	private Quyen quyen;

	public Nguoidung() {
	}

	public long getIdNguoiDung() {
		return this.idNguoiDung;
	}

	public void setIdNguoiDung(long idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenDangNhap() {
		return this.tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getTenNguoiDung() {
		return this.tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public Quyen getQuyen() {
		return this.quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

}