package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Chucvu;

public interface ChucvuRepo extends JpaRepository<Chucvu, Long>{

	@Query
	Chucvu findByIdChucVu(long id);
}
