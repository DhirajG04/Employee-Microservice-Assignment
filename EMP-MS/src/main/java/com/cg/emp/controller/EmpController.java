package com.cg.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.emp.client.AuthClient;
import com.cg.emp.model.EmpModel;
import com.cg.emp.repository.EmpRepository;

@RestController
//@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	AuthClient authClient;
	
//    @GetMapping("/getAll")
//    public List<EmpModel> getEmployeeList() {
//        return empRepository.findAll();
//    }
    
    @GetMapping("/getAll")
	public ResponseEntity<List<EmpModel>> getEmployeeList(@RequestHeader("Authorization") String token){
		if (!authClient.getValidity(token).isValid()) {

			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}
		ResponseEntity<List<EmpModel>>	emp=  new ResponseEntity<>(empRepository.findAll(), HttpStatus.OK);
		return emp;
	}

    
    
    @GetMapping("/get/{empId}")
    public EmpModel getEmployeeById(@PathVariable String empId) {
        return empRepository.findById(empId).get();
    }
    
    
//    @GetMapping("/get/{empId}")
//   	public ResponseEntity<EmpModel> getEmployeeById(@RequestHeader("Authorization") String token){
//   		if (!authClient.getValidity(token).isValid()) {
//
//   			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
//   		}
//   		ResponseEntity<EmpModel> emp= new ResponseEntity<>(empRepository.findById(id), HttpStatus.OK);
//   		return emp;
//   	}

    
    @PostMapping("/add")
    public EmpModel addEmployee(@RequestBody EmpModel empModel) {
        return empRepository.save(empModel);
    }
}
