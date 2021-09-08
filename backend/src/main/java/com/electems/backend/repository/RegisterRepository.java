/**
 * 
 */
package com.electems.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electems.backend.entity.Register;

/**
 * Register Repository
 *
 */
@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer>{

	@Query(value = "SELECT r FROM Register r WHERE r.userName=:userName")
	List<Register> checkDuplicates(@Param(value = "userName") String userName);
	
	Page<Register> findByFullNameContaining(String fullName, Pageable pageable);
}
