package com.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional(readOnly = true)
	public Page<User> getPage(Integer page, Integer size) {
		Pageable pageable =new PageRequest(page,size);
		Page<User> pageList=(Page<User>) userRepository.findAll(pageable);
		return pageList;
	}

	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Page<User> getPageSort(Integer pageNum, Integer pageLimit) {
		Sort sort=new Sort(Sort.Direction.DESC,"cTime");
		Pageable pageable=new PageRequest(pageNum-1, pageLimit,sort);
		return (Page<User>) userRepository.findAll(pageable);
	}

	@Override
	public User findByUser(String name, String password) {
		// TODO 自动生成的方法存根
		return userRepository.findByUser(name, password);
	}

	@Override
	public List<User> findAll() {
		// TODO 自动生成的方法存根
		return userRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> findByType(String name, String password, String phone) {
		return (List<User>) userRepository.findByType(name,password,phone);
	}

	public Page<User> getPageByType(String name, String password, String phone, Integer page, Integer size) {
		Pageable pageable =new PageRequest(page,size);
		Specification<User> speci1=new Specification<User>() {
					@Override
					public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
						Predicate p1=criteriaBuilder.like(root.get("name"), "%"+name+"%");
						Predicate p2=criteriaBuilder.like(root.get("password"), "%"+password+"%");
						Predicate p3=criteriaBuilder.like(root.get("phone"), "%"+phone+"%");
						return criteriaBuilder.or(p1,p2,p3);
					}
				};
		Page<User> pageList=userRepository.findAll(speci1,pageable);
		return pageList;
	}

}
