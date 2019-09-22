package com.service;

import java.util.List;

import com.entity.Menu;

public interface MenuService {
	List<Menu> findByMenuId(Integer id);
	List<Menu> findByParentId(Integer id);
	List<Menu> findById1(Integer id);
	List<Menu> findByRoleId(Integer id);
}
