/**
 * 
 */
package com.electems.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electems.backend.entity.Register;
import com.electems.backend.service.RegisterService;

/**
 * Controller Class
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	/**
	 * to save registered data in database
	 *
	 */
	@PostMapping("/listOfData")
	public Register saveStudent(@RequestBody Register register) {
		return registerService.save(register);
	}

	/**
	 * to retrieve all registered data from database
	 *
	 */
	@GetMapping("/listOfData")
	public List<Register> getAllRegisteredData() {
		return registerService.getAllRegisteredData();
	}

	/**
	 * to retrieve registered data by Id
	 *
	 */
	@GetMapping("/listOfData/{id}")
	public Register getDataById(@PathVariable Integer id) {
		return registerService.getDataById(id);
	}

	/**
	 * to delete registered data by Id
	 *
	 */
	@DeleteMapping("listOfData/{id}")
	public void deleteDataById(@PathVariable Integer id) {
		registerService.deleteById(id);
	}

	/**
	 * to update registered data by Id
	 *
	 */
	@PutMapping("listOfData/{id}")
	public Register updateDate(@PathVariable Integer id, @RequestBody Register register) {
		return registerService.updateData(id, register);
	}

	/**
	 * to retrieve registered data by Id
	 *
	 */
	@GetMapping("/listOfData/duplicate/{userName}")
	public List<Register> checkDuplicate(@PathVariable String userName) {
		return registerService.checkDuplicates(userName);
	}

}
