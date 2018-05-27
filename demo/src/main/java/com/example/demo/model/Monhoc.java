package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the monhoc database table.
 * 
 */
@Entity
@NamedQuery(name="Monhoc.findAll", query="SELECT m FROM Monhoc m")
public class Monhoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MONHOC_IDMONHOC_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="MONHOC_IDMONHOC_GENERATOR")
	@Column(name="id_mon_hoc")
	private String idMonHoc;

	@Column(name="ma_mon_hoc")
	private String maMonHoc;

	@Column(name="si_so")
	private int siSo;

	@Column(name="so_tiet")
	private int soTiet;

	@Column(name="so_tin_chi")
	private int soTinChi;

	@Column(name="ten_lop")
	private String tenLop;

	@Column(name="ten_mon_hoc")
	private String tenMonHoc;

	public Monhoc() {
	}

	public String getIdMonHoc() {
		return this.idMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}

	public String getMaMonHoc() {
		return this.maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public int getSiSo() {
		return this.siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	public int getSoTiet() {
		return this.soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public int getSoTinChi() {
		return this.soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public String getTenLop() {
		return this.tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenMonHoc() {
		return this.tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

}