/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Course;

/**
 * @author win7
 *
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {}
