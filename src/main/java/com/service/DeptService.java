package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.Dept;

public interface DeptService {
	List<Dept> findAll();
	void deleteById(Integer id);
	Dept findByDeptId(Integer id);
	void save(Dept dept);
	Page<Dept> getPage(Integer page,Integer size);
	Page<Dept> getPageSort(Integer pageNum, Integer pageLimit);
}
