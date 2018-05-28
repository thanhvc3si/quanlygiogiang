package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the hanhdong database table.
 * 
 */
@Entity
@NamedQuery(name="Hanhdong.findAll", query="SELECT h FROM Hanhdong h")
public class Hanhdong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HANHDONG_IDHANHDONG_GENERATOR", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="HANHDONG_IDHANHDONG_GENERATOR")
	@Column(name="id_hanh_dong")
	private long idHanhDong;

	@Column(name="ma_hanh_dong")
	private String maHanhDong;

	@Column(name="ten_hanh_dong")
	private String tenHanhDong;
	
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

	public List<Monhoc> getMonhocs() {
		return monhocs;
	}

	public void setMonhocs(List<Monhoc> monhocs) {
		this.monhocs = monhocs;
	}

	public Hanhdong() {
	}

	public long getIdHanhDong() {
		return this.idHanhDong;
	}

	public void setIdHanhDong(long idHanhDong) {
		this.idHanhDong = idHanhDong;
	}

	public String getMaHanhDong() {
		return this.maHanhDong;
	}

	public void setMaHanhDong(String maHanhDong) {
		this.maHanhDong = maHanhDong;
	}

	public String getTenHanhDong() {
		return this.tenHanhDong;
	}

	public void setTenHanhDong(String tenHanhDong) {
		this.tenHanhDong = tenHanhDong;
	}

}