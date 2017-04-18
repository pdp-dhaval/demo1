/**
 * 
 */
package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Course;
import com.example.model.StudentCourseMapping;

/**
 * @author win7
 *
 */
public interface StudentCourseMappingRepository extends JpaRepository<StudentCourseMapping, Integer> {
	
	@Transactional
	public void deleteByStudentId(Integer id);
	
	@Query("select map.course from StudentCourseMapping map where map.student.id = :id")
	public List<Course> findCourseByStudentId(@Param("id") Integer id);
	
}
