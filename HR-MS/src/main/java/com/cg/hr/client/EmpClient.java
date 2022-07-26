package com.cg.hr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hr.model.EmpModel;


@FeignClient(name = "empfeign",url="http://localhost:9001")
public interface EmpClient {
	

    @GetMapping("/getAll")
    public List<EmpModel> getEmployeeList();
    
    @GetMapping("/get/{empId}")
    public EmpModel getEmployeeById(@PathVariable String empId);
    
    @PostMapping("/add")
    public EmpModel addEmployee(@RequestBody EmpModel empModel);
	
}
