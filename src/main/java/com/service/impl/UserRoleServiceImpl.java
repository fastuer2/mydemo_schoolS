package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserRole;
import com.repository.UserRoleRepository;
import com.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Override
	public List<UserRole> findByRid(Integer id) {
		// TODO 自动生成的方法存根
		return userRoleRepository.findByRid(id);
	}

}
