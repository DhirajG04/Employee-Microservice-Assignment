package com.cg.hr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hr.model.LocModel;


@FeignClient(name = "locfeign",url="http://localhost:9003")
public interface LocClient {

		@GetMapping("/getAll")
	    public List<LocModel> getLocationList();
	    
	    @GetMapping("/get/{locId}")
	    public LocModel getLocationById(@PathVariable String locId);
	    
	    @PostMapping("/add")
	    public LocModel addLocation(@RequestBody LocModel locModel);
}
