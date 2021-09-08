/**
 * 
 */
package com.electems.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electems.backend.entity.Register;
import com.electems.backend.repository.RegisterRepository;

/**
 * Service Class for register
 *
 */
@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	/**
	 * method to save registered data
	 *
	 */
	public Register save(Register reg) {
		
		return registerRepository.save(reg);
	}
	
	/**
	 * method to get all registered data
	 *
	 */
	public List<Register> getAllRegisteredData(){
		return registerRepository.findAll();
	}
	
	/**
	 * method to get registered data by ID
	 *
	 */
	public Register getDataById(Integer id){
		return registerRepository.getById(id);
	}
	
	/**
	 * method to delete registered data by id
	 *
	 */
	public void deleteById(Integer id){
		registerRepository.deleteById(id);
	}
	
	/**
	 * method to update registered data by id
	 *
	 */
	public Register updateData(Integer id,Register register){
		Register student=registerRepository.getById(id);
		if(student != null)
			student.setFullName(register.getFullName());
			student.setPhoneNumber(register.getPhoneNumber());
			student.setUserName(register.getUserName());
			student.setEmail(register.getEmail());
			student.setPassword(register.getPassword());
			registerRepository.save(student);
			return student;
	}
	
	/**
	 * method to check for duplicate username
	 *
	 */
	public List<Register> checkDuplicates(String userName){
		return registerRepository.checkDuplicates(userName);
	}	
}
