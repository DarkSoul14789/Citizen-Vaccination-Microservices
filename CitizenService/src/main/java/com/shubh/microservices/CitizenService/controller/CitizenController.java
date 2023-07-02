package com.shubh.microservices.CitizenService.controller;

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

import com.shubh.microservices.CitizenService.entity.Citizen;
import com.shubh.microservices.CitizenService.service.CService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private CService cService;
	
//	Find all citizens in vaccination center
	@GetMapping("/vid/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
		List<Citizen> citiList = this.cService.fetchCitizenByVaccinationCentre(id);
		return new ResponseEntity<List<Citizen>>(citiList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen c){
		Citizen citizen = this.cService.addCitizen(c);
		return new ResponseEntity<Citizen>(citizen, HttpStatus.CREATED);
	}
}
