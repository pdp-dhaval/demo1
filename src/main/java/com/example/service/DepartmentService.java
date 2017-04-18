/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.model.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;

/**
 * @author win7
 *
 */
@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;

	public List<Department> getDepartments(){
		List<Department> tempDeps = new ArrayList<>();
		List<Department> dbDepartments = repository.findAll();
		dbDepartments.forEach(tempDeps::add);
		return tempDeps;
	}
}
