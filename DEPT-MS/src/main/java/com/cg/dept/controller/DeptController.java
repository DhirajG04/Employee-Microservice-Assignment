package com.cg.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.cg.dept.client.AuthClient;
import com.cg.dept.model.DeptModel;
import com.cg.dept.repository.DeptRepository;


@RestController
//@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	AuthClient authClient;
	
	
//    @GetMapping("/getAll")
//    public List<DeptModel> getDepartmentList() {
//        return deptRepository.findAll();
//    }
	
	
	@GetMapping("/getAllDept")
	public ResponseEntity<List<DeptModel>> getDepartmentList(@RequestHeader("Authorization") String token){
		if (!authClient.getValidity(token).isValid()) {

			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}
		ResponseEntity<List<DeptModel>>	dept=  new ResponseEntity<>(deptRepository.findAll(), HttpStatus.OK);
		return dept;
	}
	
    
    @GetMapping("/get/{deptId}")
    public DeptModel getDepartmentById(@PathVariable String deptId) {
        return deptRepository.findById(deptId).get();
    }
    
    @PostMapping("/add")
    public DeptModel addDepartment(@RequestBody DeptModel deptModel) {
        return deptRepository.save(deptModel);
    }
}
