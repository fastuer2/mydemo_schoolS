package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.User;

public interface UserService {
	Page<User> getPageByType(String name, String password, String phone,Integer page,Integer size);
	Page<User> getPage(Integer page,Integer size);
	Page<User> getPageSort(Integer pageNum, Integer pageLimit);
	User findByUser(String name,String password);
	List<User> findAll();
	void save(User user);
	void deleteById(Integer id);
}
