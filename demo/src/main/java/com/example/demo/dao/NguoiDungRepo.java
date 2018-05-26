package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Nguoidung;

@Repository
public interface NguoiDungRepo extends BaseRepository, JpaRepository<Nguoidung, Long>{
	@Query("SELECT u FROM Nguoidung u WHERE LOWER(u.tenDangNhap) = LOWER(:tenDangNhap)")
	Nguoidung findByUserNameCaseInsensitive(@Param("tenDangNhap") String tenDangNhap);
}
