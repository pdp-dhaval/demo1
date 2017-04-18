/**
 * 
 */
package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Gender;
/**
 * @author win7
 *
 */
public interface GenderRepository extends JpaRepository<Gender, Integer> {
	
}
