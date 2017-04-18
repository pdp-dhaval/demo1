/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Gender;
import com.example.model.Student;
import com.example.repository.GenderRepository;
import com.example.repository.StudentRepository;

/**
 * @author win7
 *
 */
@Service
public class GenderService {
	
	@Autowired
	private GenderRepository genderRepository;

	public List<Gender> getGenders(){
		return genderRepository.findAll();
	}
}
