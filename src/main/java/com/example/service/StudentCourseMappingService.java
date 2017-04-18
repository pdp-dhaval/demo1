/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.model.StudentCourseMapping;
import com.example.repository.StudentCourseMappingRepository;

/**
 * @author win7
 *
 */
@Service
public class StudentCourseMappingService {
	
	@Autowired
	private StudentCourseMappingRepository courseMappingRepository;

	public void addStudentCourseMapping(StudentCourseMapping mapping){
		courseMappingRepository.save(mapping);
	}
	
	public List<Course> getCoursesByStudentId(Integer id){
		return courseMappingRepository.findCourseByStudentId(id);
	}
}
