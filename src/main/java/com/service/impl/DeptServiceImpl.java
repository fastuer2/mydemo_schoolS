package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.entity.Dept;
import com.repository.DeptRepository;
import com.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptRepository deptRepository;
	@Override
	public List<Dept> findAll() {
		// TODO 自动生成的方法存根
		return deptRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		deptRepository.deleteById(id);
	}

	@Override
	public Dept findByDeptId(Integer id) {
		Dept dept = deptRepository.findByDeptId(id);
		return dept;
	}

	@Override
	public void save(Dept dept) {
		// TODO 自动生成的方法存根
		deptRepository.save(dept);
	}

	@Override
	public Page<Dept> getPage(Integer page, Integer size) {
		Pageable pageable =new PageRequest(page,size);
		Page<Dept> pageList = deptRepository.findAll(pageable);
		return pageList;
	}

	@Override
	public Page<Dept> getPageSort(Integer pageNum, Integer pageLimit) {
		Sort sort=new Sort(Sort.Direction.DESC,"id");
		Pageable pageable=new PageRequest(pageNum, pageLimit,sort);
		return deptRepository.findAll(pageable);
	}
	
}
