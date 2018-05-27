package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Monhoc;

public interface MonhocRepo extends JpaRepository<Monhoc, Long>{
	
	@Query
	Monhoc findByMaMonHoc(String maMonHoc);
}
