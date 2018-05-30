package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Hanhdong;

public interface HanhdongService {

	Hanhdong getinfo(long id);
	
	List<Hanhdong> list();
}
