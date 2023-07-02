package com.shubh.microservices.VaccinationCenter.controllers;

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
import org.springframework.web.client.RestTemplate;

import com.shubh.microservices.VaccinationCenter.entities.VaccinationCenter;
import com.shubh.microservices.VaccinationCenter.model.Citizen;
import com.shubh.microservices.VaccinationCenter.model.Response;
import com.shubh.microservices.VaccinationCenter.services.VaccinationCenterService;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterService vcService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter vc){
		VaccinationCenter center = this.vcService.addCenter(vc);
		return new ResponseEntity<VaccinationCenter>(center, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<VaccinationCenter>> getCenters(){
		List<VaccinationCenter> centers = this.vcService.getCenters();
		return new ResponseEntity<List<VaccinationCenter>>(centers, HttpStatus.OK);
	}
	
	@GetMapping("/vid/{id}")
	public ResponseEntity<Response> getAllCitizensInCenter(@PathVariable Integer id){
		Response res = new Response();
//		get vaccination center details
		VaccinationCenter center = this.vcService.getCenter(id);
		res.setCenter(center);
		
//		then get all citizens registered to vaccination center
		@SuppressWarnings("unchecked")
		List<Citizen> citizens = this.restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/vid/"+id, List.class);
		res.setCitizens(citizens);
		
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}
}
