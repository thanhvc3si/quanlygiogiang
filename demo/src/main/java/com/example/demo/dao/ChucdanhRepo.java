package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Chucdanh;

public interface ChucdanhRepo extends JpaRepository<Chucdanh, Long> {
	
	@Query
	Chucdanh findByIdChucDanh(long id);
}
