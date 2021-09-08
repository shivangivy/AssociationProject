/**
 * 
 */
package com.electems.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electems.backend.entity.Course;
import com.electems.backend.entity.Register;
import com.electems.backend.repository.CourseRepository;
import com.electems.backend.repository.RegisterRepository;


/**
 * Course Service Class
 *
 */
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	/**
	 * to get list of course
	 *
	 */
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	/**
	 * to save course
	 *
	 */
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
}
