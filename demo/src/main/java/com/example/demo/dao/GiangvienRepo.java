package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Giangvien;

@Repository
public interface GiangvienRepo extends BaseRepository, JpaRepository<Giangvien, Long>{
	
	
}
