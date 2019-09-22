package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>,JpaSpecificationExecutor<Dept>,PagingAndSortingRepository<Dept, Integer> {
	@Query(value="select * from t_dept order by id asc",nativeQuery=true)
	List<Dept> findAll();
	@Query(value="select * from t_dept where id=?1",nativeQuery=true)
	Dept findByDeptId(Integer id);
	@Transactional
	@Modifying
	@Query(value="delete from t_dept where id=?1",nativeQuery=true)
	void deleteById(Integer id);
}
