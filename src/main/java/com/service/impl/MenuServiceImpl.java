package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Menu;
import com.repository.MenuRepository;
import com.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menuRepository;
	@Override
	public List<Menu> findByMenuId(Integer id) {
		return menuRepository.findByMenuId(id);
	}
	@Override
	public List<Menu> findByParentId(Integer id) {
		// TODO 自动生成的方法存根
		return menuRepository.findByParentId(id);
	}
	@Override
	public List<Menu> findById1(Integer id) {
		// TODO 自动生成的方法存根
		return menuRepository.findById1(id);
	}
	@Override
	public List<Menu> findByRoleId(Integer id) {
		// TODO 自动生成的方法存根
		return menuRepository.findByRoleId(id);
	}
	
}
