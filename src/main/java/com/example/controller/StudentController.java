/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Course;
import com.example.model.Department;
import com.example.model.Gender;
import com.example.model.Student;
import com.example.service.CourseService;
import com.example.service.DepartmentService;
import com.example.service.GenderService;
import com.example.service.StudentCourseMappingService;
import com.example.service.StudentService;

/**
 * @author win7
 *
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseMappingService studentCourseMappingService; 
	
	
	@RequestMapping(value = {"/students"}, method = RequestMethod.GET)
	public List<Student> getStudents(){
	  return service.getStudents();
	}
	
	@RequestMapping(value = {"/student/{id}"}, method = RequestMethod.GET)
	public Student student(@PathVariable Integer id){
	  return service.getStudent(id);
	}
	
	
	@RequestMapping(value = {"/add_student"}, method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student){
	  service.addUpdateStudent(student);
	}
	
	@RequestMapping(value = {"/update_student"}, method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student){
	  service.addUpdateStudent(student);
	}
	
	@RequestMapping(value = {"/delete_student/{id}"}, method = RequestMethod.DELETE)
	public void updateStudent(@PathVariable Integer id){
	  service.deleteStudent(id);
	}
	
	@RequestMapping(value = {"/departments"}, method = RequestMethod.GET)
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
	
	@RequestMapping(value = {"/students_by_department/{deptId}"}, method = RequestMethod.GET)
	public List<Student> getDepartments(@PathVariable Integer deptId){
		return service.getStudentByDepartment(deptId);
	}
	
	@RequestMapping(value = {"/genders"}, method = RequestMethod.GET)
	public List<Gender> getGenders(){
		return genderService.getGenders();
	}
	@RequestMapping(value = {"/courses"}, method = RequestMethod.GET)
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	@RequestMapping(value = {"/courses_by_student_id/{id}"}, method = RequestMethod.GET)
	public List<Course> getCourses(@PathVariable Integer id){
		return studentCourseMappingService.getCoursesByStudentId(id);
	}
}
