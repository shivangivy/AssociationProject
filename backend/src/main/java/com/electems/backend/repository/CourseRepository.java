/**
 * 
 */
package com.electems.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electems.backend.entity.Course;

/**
 * Course Repository
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
}
