package com.cg.hr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="departments")
public class DeptModel {
	
	@Id
	private String deptId;	
	private String dname;
	private String locId;
	
	public  DeptModel() {
		// TODO Auto-generated constructor stub
	}

	public DeptModel(String deptId, String dname, String locId) {
		
		this.deptId = deptId;
		this.dname = dname;
		this.locId = locId;
	}



	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	@Override
	public String toString() {
		return "DeptModel [deptId=" + deptId + ", dname=" + dname + ", locId=" + locId + "]";
	}


		
}
