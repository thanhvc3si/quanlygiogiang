package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Phongban;

public interface PhongbanRepo extends JpaRepository<Phongban, Long>{

	@Query
	Phongban findByIdPhongBan(long id);
}
