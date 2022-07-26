package com.cg.loc.controller;

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

import com.cg.loc.client.AuthClient;
import com.cg.loc.model.LocModel;
import com.cg.loc.repository.LocRepository;


@RestController
//@RequestMapping("/loc")
public class LocController {

	@Autowired
	private LocRepository locRepository;
	
	@Autowired
	AuthClient authClient;
	
//    @GetMapping("/getAll")
//    public List<LocModel> getLocationList() {
//        return locRepository.findAll();
//    }
	
	
	@GetMapping("/getAllLoc")
	public ResponseEntity<List<LocModel>> getLocationList(@RequestHeader("Authorization") String token){
		if (!authClient.getValidity(token).isValid()) {

			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}
		ResponseEntity<List<LocModel>>	loc=  new ResponseEntity<>(locRepository.findAll(), HttpStatus.OK);
		return loc;
	}
	
    
    @GetMapping("/get/{locId}")
    public LocModel getLocationById(@PathVariable String locId) {
        return locRepository.findById(locId).get();
    }
    
    @PostMapping("/add")
    public LocModel addLocation(@RequestBody LocModel locModel) {
        return locRepository.save(locModel);
    }
}
