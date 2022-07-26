package com.cg.emp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class EmpModel {
	
	@Id
	private String empId;
	private String name;
	private String deptId;
	
	
	public  EmpModel() {
		// TODO Auto-generated constructor stub
	}


	public EmpModel(String empId, String name, String deptId) {
	
		this.empId = empId;
		this.name = name;
		this.deptId = deptId;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "EmpModel [empId=" + empId + ", name=" + name + ", deptId=" + deptId + "]";
	}
	
}
