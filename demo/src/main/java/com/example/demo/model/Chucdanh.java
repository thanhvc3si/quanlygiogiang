package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the chucdanh database table.
 * 
 */
@Entity
@NamedQuery(name="Chucdanh.findAll", query="SELECT c FROM Chucdanh c")
public class Chucdanh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHUCDANH_IDCHUCDANH_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHUCDANH_IDCHUCDANH_GENERATOR")
	@Column(name="id_chuc_danh")
	private long idChucDanh;

	@Column(name="ma_chuc_danh")
	private String maChucDanh;

	@Column(name="ten_chuc_danh")
	private String tenChucDanh;

	//bi-directional many-to-one association to Giangvien
	@OneToMany(mappedBy="chucdanh")
	@JsonIgnore
	private List<Giangvien> giangviens;

	public Chucdanh() {
	}

	public long getIdChucDanh() {
		return this.idChucDanh;
	}

	public void setIdChucDanh(long idChucDanh) {
		this.idChucDanh = idChucDanh;
	}

	public String getMaChucDanh() {
		return this.maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public String getTenChucDanh() {
		return this.tenChucDanh;
	}

	public void setTenChucDanh(String tenChucDanh) {
		this.tenChucDanh = tenChucDanh;
	}

	public List<Giangvien> getGiangviens() {
		return this.giangviens;
	}

	public void setGiangviens(List<Giangvien> giangviens) {
		this.giangviens = giangviens;
	}

	public Giangvien addGiangvien(Giangvien giangvien) {
		getGiangviens().add(giangvien);
		giangvien.setChucdanh(this);

		return giangvien;
	}

	public Giangvien removeGiangvien(Giangvien giangvien) {
		getGiangviens().remove(giangvien);
		giangvien.setChucdanh(null);

		return giangvien;
	}

}