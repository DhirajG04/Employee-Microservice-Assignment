package com.cg.hr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hr.model.DeptModel;



@FeignClient(name = "deptfeign",url="http://localhost:9002")
public interface DeptClient {

	
	 	@GetMapping("/getAll")
	 	public List<DeptModel> getDepartmentList();
	    
	 	
	    @GetMapping("/get/{deptId}")
	    public DeptModel getDepartmentById(@PathVariable String deptId);
	    
	    @PostMapping("/add")
	    public DeptModel addDepartment(@RequestBody DeptModel deptModel);
}
