/**
 * 
 */
package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Student;

/**
 * @author win7
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//Query Method
	public List<Student> findByDepartmentId(Integer id);
	
	//Named Parameter
}
