/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Department;

/**
 * @author win7
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
