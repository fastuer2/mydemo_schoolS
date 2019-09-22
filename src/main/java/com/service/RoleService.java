package com.service;

import java.util.List;

import com.entity.Role;

public interface RoleService {
	List<Role> findByUserId(Integer id);
}
