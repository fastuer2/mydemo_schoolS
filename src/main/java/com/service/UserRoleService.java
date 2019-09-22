package com.service;

import java.util.List;

import com.entity.UserRole;

public interface UserRoleService {
	List<UserRole> findByRid(Integer id);
}
