package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{
	@Modifying
	@Query(value="select * from t_menu where id in (select mid from t_role_menu where rid=?1)",nativeQuery=true)
	List<Menu> findByMenuId(Integer id);
	
	@Modifying
	@Query(value="select * from t_menu start with id=?1 connect by  prior id=parentid",nativeQuery=true)
	List<Menu> findByRoleId(Integer id);
	@Modifying
	@Query(value="select * from t_menu where parentid=?1",nativeQuery=true)
	List<Menu> findByParentId(Integer id);
	
	@Modifying
	@Query(value="select * from t_menu where id=?1",nativeQuery=true)
	List<Menu> findById1(Integer id);
	
}
