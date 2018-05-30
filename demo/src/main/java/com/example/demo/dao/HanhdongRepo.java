package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Hanhdong;

public interface HanhdongRepo extends JpaRepository<Hanhdong, Long>{

	@Query
	Hanhdong findByIdHanhDong(long id);
}
