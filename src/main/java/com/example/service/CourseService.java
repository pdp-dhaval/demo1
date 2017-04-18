/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.model.Department;
import com.example.model.Student;
import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;

/**
 * @author win7
 *
 */
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
}
