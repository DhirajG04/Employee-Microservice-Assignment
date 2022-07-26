package com.cg.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hr.client.DeptClient;
import com.cg.hr.client.EmpClient;
import com.cg.hr.client.LocClient;
import com.cg.hr.model.DeptModel;
import com.cg.hr.model.EmpModel;
import com.cg.hr.model.LocModel;

@EnableFeignClients(basePackages = "com.cg.hr.client")
@RestController
@RequestMapping("/hr")
public class HrController {

	@Autowired
	EmpClient empfeign;
	
	@Autowired
	DeptClient deptfeign;

	@Autowired
	LocClient locfeign;
	
	@GetMapping("/getOneEmp/{empId}")
	public EmpModel getEmpDetail(@PathVariable String empId) {
		return empfeign.getEmployeeById(empId);
	}
	
	@GetMapping("/getOneDept/{deptId}")
	public DeptModel getDepartmentById(@PathVariable String deptId) {
	   	return deptfeign.getDepartmentById(deptId);
	}
	
	@GetMapping("/getOne/{locId}")
    public LocModel getLocationById(@PathVariable String locId) {
    	return locfeign.getLocationById(locId);
    }
}
