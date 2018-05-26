package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the phongban database table.
 * 
 */
@Entity
@NamedQuery(name="Phongban.findAll", query="SELECT p FROM Phongban p")
public class Phongban implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PHONGBAN_IDPHONGBAN_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHONGBAN_IDPHONGBAN_GENERATOR")
	@Column(name="id_phong_ban")
	private long idPhongBan;

	@Column(name="ma_phong_ban")
	private String maPhongBan;

	@Column(name="ten_phong_ban")
	private String tenPhongBan;

	//bi-directional many-to-one association to Giangvien
	@OneToMany(mappedBy="phongban")
	@JsonIgnore
	private List<Giangvien> giangviens;

	public Phongban() {
	}

	public long getIdPhongBan() {
		return this.idPhongBan;
	}

	public void setIdPhongBan(long idPhongBan) {
		this.idPhongBan = idPhongBan;
	}

	public String getMaPhongBan() {
		return this.maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return this.tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<Giangvien> getGiangviens() {
		return this.giangviens;
	}

	public void setGiangviens(List<Giangvien> giangviens) {
		this.giangviens = giangviens;
	}

	public Giangvien addGiangvien(Giangvien giangvien) {
		getGiangviens().add(giangvien);
		giangvien.setPhongban(this);

		return giangvien;
	}

	public Giangvien removeGiangvien(Giangvien giangvien) {
		getGiangviens().remove(giangvien);
		giangvien.setPhongban(null);

		return giangvien;
	}

}