/**
 * 
 */
package com.electems.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electems.backend.entity.Register;
import com.electems.backend.repository.RegisterRepository;
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
	
	@Autowired
	private RegisterRepository RegisterRepository;
	
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
	
	/**
	 * rest api to get student list with pagination
	 *
	 */
	@GetMapping("/students")
	  public ResponseEntity<Map<String, Object>> getAllStudents(
			  @RequestParam(required = false) String name,
			  @RequestParam(defaultValue = "0") int page,
			  @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<Register> students = new ArrayList<Register>();
	      Pageable paging = PageRequest.of(page, size);
	      Page<Register> pageTuts = null;
	      if(name== null)
	    	  pageTuts = RegisterRepository.findAll(paging);
	      else
	    	  pageTuts= RegisterRepository.findByFullNameContaining(name, paging);
	      students = pageTuts.getContent();
	      Map<String, Object> response = new HashMap<>();
	      response.put("students", students);
	      response.put("currentPage", pageTuts.getNumber());
	      response.put("totalItems", pageTuts.getTotalElements());
	      response.put("totalPages", pageTuts.getTotalPages());
	     
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	  }

}
