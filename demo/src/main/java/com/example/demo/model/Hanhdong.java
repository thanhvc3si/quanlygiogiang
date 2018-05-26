package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hanhdong database table.
 * 
 */
@Entity
@NamedQuery(name="Hanhdong.findAll", query="SELECT h FROM Hanhdong h")
public class Hanhdong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HANHDONG_IDHANHDONG_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HANHDONG_IDHANHDONG_GENERATOR")
	@Column(name="id_hanh_dong")
	private long idHanhDong;

	@Column(name="so_luong")
	private int soLuong;

	@Column(name="ten_hanh_dong")
	private String tenHanhDong;

	//bi-directional many-to-many association to Giangvien
	@ManyToMany(mappedBy="hanhdongs")
	private List<Giangvien> giangviens;

	//bi-directional many-to-many association to Monhoc
	@ManyToMany
	@JoinTable(
		name="hanhdong_monhoc"
		, joinColumns={
			@JoinColumn(name="id_hanh_dong")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_mon_hoc")
			}
		)
	private List<Monhoc> monhocs;

	public Hanhdong() {
	}

	public long getIdHanhDong() {
		return this.idHanhDong;
	}

	public void setIdHanhDong(long idHanhDong) {
		this.idHanhDong = idHanhDong;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenHanhDong() {
		return this.tenHanhDong;
	}

	public void setTenHanhDong(String tenHanhDong) {
		this.tenHanhDong = tenHanhDong;
	}

	public List<Giangvien> getGiangviens() {
		return this.giangviens;
	}

	public void setGiangviens(List<Giangvien> giangviens) {
		this.giangviens = giangviens;
	}

	public List<Monhoc> getMonhocs() {
		return this.monhocs;
	}

	public void setMonhocs(List<Monhoc> monhocs) {
		this.monhocs = monhocs;
	}

}