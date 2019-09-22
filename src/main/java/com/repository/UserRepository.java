package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> ,JpaSpecificationExecutor<User>,PagingAndSortingRepository<User, Integer>{
	@Query("select u from User u where u.name=?1 and u.password=?2")
	User findByUser(String name,String password);
	
	@Transactional
	@Modifying
	@Query("delete from User u where u.id=?1")
	void deleteById(Integer id);
	
	@Query("select u from User u where u.name like %?1% or u.password like %?2% or u.phone like %?3%")
	List<User> findByType(String name, String password, String phone);
}
