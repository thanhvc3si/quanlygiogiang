package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quyen database table.
 * 
 */
@Entity
@NamedQuery(name="Quyen.findAll", query="SELECT q FROM Quyen q")
public class Quyen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUYEN_IDQUYEN_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUYEN_IDQUYEN_GENERATOR")
	@Column(name="id_quyen")
	private long idQuyen;

	@Column(name="ten_quyen")
	private String tenQuyen;

	//bi-directional many-to-one association to Nguoidung
	@OneToMany(mappedBy="quyen")
	private List<Nguoidung> nguoidungs;

	public Quyen() {
	}

	public long getIdQuyen() {
		return this.idQuyen;
	}

	public void setIdQuyen(long idQuyen) {
		this.idQuyen = idQuyen;
	}

	public String getTenQuyen() {
		return this.tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public List<Nguoidung> getNguoidungs() {
		return this.nguoidungs;
	}

	public void setNguoidungs(List<Nguoidung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}

	public Nguoidung addNguoidung(Nguoidung nguoidung) {
		getNguoidungs().add(nguoidung);
		nguoidung.setQuyen(this);

		return nguoidung;
	}

	public Nguoidung removeNguoidung(Nguoidung nguoidung) {
		getNguoidungs().remove(nguoidung);
		nguoidung.setQuyen(null);

		return nguoidung;
	}

}