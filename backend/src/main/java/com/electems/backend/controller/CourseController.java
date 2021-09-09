/**
 * 
 */
package com.electems.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electems.backend.entity.Course;
import com.electems.backend.entity.Register;
import com.electems.backend.service.CourseService;

/**
 * CourseController Class
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * to get list of course
	 *
	 */
	@GetMapping("/courses")
	public List<Course> getAllCourse(){
		return courseService.getAllCourse();
	}
	
	/**
	 * to save list of course
	 *
	 */
	@PostMapping("/course/{regId}")
	public Course saveStudent(@RequestBody Course course,@PathVariable Integer regId) {
		return courseService.save(course, regId);
	}
	
}
