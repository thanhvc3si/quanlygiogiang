package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the giangvien database table.
 * 
 */
@Entity
@NamedQuery(name="Giangvien.findAll", query="SELECT g FROM Giangvien g")
public class Giangvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GIANGVIEN_IDGIANGVIEN_GENERATOR", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="GIANGVIEN_IDGIANGVIEN_GENERATOR")
	@Column(name="id_giang_vien")
	private long idGiangVien;

	@Column(name="birth_day")
	private String birthDay;

	@Column(name="full_name")
	private String fullName;

	@Column(name="ma_gv")
	private String maGv;

	@Column(name="que_quan")
	private String queQuan;
	
	@Transient
	private double dinhMucGioChuan;
	
	@Transient
	private double mienGIam;
	
	@Transient
	private double soGioThucHien;
	
	@Transient
	private double tong;
	
	@Transient
	private double thua;
	
	@Transient
	private double thieu;

	//bi-directional many-to-one association to Chucdanh
	@ManyToOne
	@JoinColumn(name="id_chuc_danh")
	private Chucdanh chucdanh;

	//bi-directional many-to-one association to Chucvu
	@ManyToOne
	@JoinColumn(name="id_chuc_vu")
	private Chucvu chucvu;

	//bi-directional many-to-one association to Phongban
	@ManyToOne
	@JoinColumn(name="id_phong_ban")
	private Phongban phongban;

	//bi-directional many-to-many association to Hanhdong
	@ManyToMany
	@JoinTable(
		name="giangvien_hanhdong"
		, joinColumns={
			@JoinColumn(name="id_giang_vien")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_hanh_dong")
			}
		)
	private List<Hanhdong> hanhdongs;

	public Giangvien() {
	}

	public long getIdGiangVien() {
		return this.idGiangVien;
	}

	public void setIdGiangVien(long idGiangVien) {
		this.idGiangVien = idGiangVien;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMaGv() {
		return this.maGv;
	}

	public void setMaGv(String maGv) {
		this.maGv = maGv;
	}

	public String getQueQuan() {
		return this.queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Chucdanh getChucdanh() {
		return this.chucdanh;
	}

	public void setChucdanh(Chucdanh chucdanh) {
		this.chucdanh = chucdanh;
	}

	public Chucvu getChucvu() {
		return this.chucvu;
	}

	public void setChucvu(Chucvu chucvu) {
		this.chucvu = chucvu;
	}

	public Phongban getPhongban() {
		return this.phongban;
	}

	public void setPhongban(Phongban phongban) {
		this.phongban = phongban;
	}

	public List<Hanhdong> getHanhdongs() {
		return this.hanhdongs;
	}

	public void setHanhdongs(List<Hanhdong> hanhdongs) {
		this.hanhdongs = hanhdongs;
	}

	public double getDinhMucGioChuan() {
		return dinhMucGioChuan;
	}

	public void setDinhMucGioChuan(double dinhMucGioChuan) {
		this.dinhMucGioChuan = dinhMucGioChuan;
	}

	public double getMienGIam() {
		return mienGIam;
	}

	public void setMienGIam(double mienGIam) {
		this.mienGIam = mienGIam;
	}

	public double getSoGioThucHien() {
		return soGioThucHien;
	}

	public void setSoGioThucHien(double soGioThucHien) {
		this.soGioThucHien = soGioThucHien;
	}

	public double getTong() {
		return tong;
	}

	public void setTong(double tong) {
		this.tong = tong;
	}

	public double getThua() {
		return thua;
	}

	public void setThua(double thua) {
		this.thua = thua;
	}

	public double getThieu() {
		return thieu;
	}

	public void setThieu(double thieu) {
		this.thieu = thieu;
	}

	public Giangvien(long idGiangVien, String birthDay, String fullName, String maGv, String queQuan,
			double dinhMucGioChuan, double mienGIam, double soGioThucHien, double tong, double thua, double thieu,
			Chucdanh chucdanh, Chucvu chucvu, Phongban phongban, List<Hanhdong> hanhdongs) {
		super();
		this.idGiangVien = idGiangVien;
		this.birthDay = birthDay;
		this.fullName = fullName;
		this.maGv = maGv;
		this.queQuan = queQuan;
		this.dinhMucGioChuan = dinhMucGioChuan;
		this.mienGIam = mienGIam;
		this.soGioThucHien = soGioThucHien;
		this.tong = tong;
		this.thua = thua;
		this.thieu = thieu;
		this.chucdanh = chucdanh;
		this.chucvu = chucvu;
		this.phongban = phongban;
		this.hanhdongs = hanhdongs;
	}
	
	
	

}