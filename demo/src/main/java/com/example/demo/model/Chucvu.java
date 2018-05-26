package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the chucvu database table.
 * 
 */
@Entity
@NamedQuery(name="Chucvu.findAll", query="SELECT c FROM Chucvu c")
public class Chucvu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHUCVU_IDCHUCVU_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHUCVU_IDCHUCVU_GENERATOR")
	@Column(name="id_chuc_vu")
	private long idChucVu;

	@Column(name="ma_chuc_vu")
	private String maChucVu;

	@Column(name="ten_chuc_vu")
	private String tenChucVu;

	//bi-directional many-to-one association to Giangvien
	@OneToMany(mappedBy="chucvu")
	@JsonIgnore
	private List<Giangvien> giangviens;

	public Chucvu() {
	}

	public long getIdChucVu() {
		return this.idChucVu;
	}

	public void setIdChucVu(long idChucVu) {
		this.idChucVu = idChucVu;
	}

	public String getMaChucVu() {
		return this.maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return this.tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public List<Giangvien> getGiangviens() {
		return this.giangviens;
	}

	public void setGiangviens(List<Giangvien> giangviens) {
		this.giangviens = giangviens;
	}

	public Giangvien addGiangvien(Giangvien giangvien) {
		getGiangviens().add(giangvien);
		giangvien.setChucvu(this);

		return giangvien;
	}

	public Giangvien removeGiangvien(Giangvien giangvien) {
		getGiangviens().remove(giangvien);
		giangvien.setChucvu(null);

		return giangvien;
	}

}