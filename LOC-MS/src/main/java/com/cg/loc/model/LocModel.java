package com.cg.loc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="departments")
public class LocModel {
	
	@Id	
	private String locId;
	private String locName;
		
	public  LocModel() {
		// TODO Auto-generated constructor stub
	}

	public LocModel(String locName, String locId) {
		
		this.locName = locName;
		this.locId = locId;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	@Override
	public String toString() {
		return "LocModel [locId=" + locId + ", locName=" + locName + "]";
	}

	
}
