/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.model.Student;
import com.example.model.StudentCourseMapping;
import com.example.repository.StudentCourseMappingRepository;
import com.example.repository.StudentRepository;

/**
 * @author win7
 *
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private StudentCourseMappingRepository courseMappingRepository;

	public List<Student> getStudents(){
		List<Student> students =repository.findAll();
		for(Student std :students){
			std.setCourses(courseMappingRepository.findCourseByStudentId(std.getId()));
		}
		return students;
		
	}
	
	public Student getStudent(Integer id){
		List<Student> students = repository.findAll();
		return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
	}
	
	public void addUpdateStudent(Student student){
		Student std = (Student)repository.save(student);
		courseMappingRepository.deleteByStudentId(std.getId());
		for(Course cour : student.getCourses()){
			StudentCourseMapping courseMapping = new StudentCourseMapping(); 
			courseMapping.setCourse(cour);
			courseMapping.setStudent(std);
			courseMappingRepository.save(courseMapping);
		}
	}
	
	public void deleteStudent(Integer id){
		repository.delete(id);
	}
	
	public List<Student> getStudentByDepartment(Integer deptId){
		return repository.findByDepartmentId(deptId);
	}
}
