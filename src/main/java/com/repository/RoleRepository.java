package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	@Query(value="Select r.* from t_role r where r.id in(select r_id from t_user_role where u_id=?1)",nativeQuery=true)
	List<Role> findByUserId(Integer id);
}
