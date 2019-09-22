package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	@Query("select ur from UserRole ur where ur.rid=?1")
	List<UserRole> findByRid(Integer id);
}
