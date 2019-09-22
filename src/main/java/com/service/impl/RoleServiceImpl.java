package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Role;
import com.repository.RoleRepository;
import com.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> findByUserId(Integer id) {
		return roleRepository.findByUserId(id);
	}
	
}
