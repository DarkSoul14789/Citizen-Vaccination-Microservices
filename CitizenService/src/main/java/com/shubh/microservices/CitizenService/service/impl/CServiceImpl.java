package com.shubh.microservices.CitizenService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.microservices.CitizenService.entity.Citizen;
import com.shubh.microservices.CitizenService.repositories.CitizenRepo;
import com.shubh.microservices.CitizenService.service.CService;

@Service
public class CServiceImpl implements CService {

	@Autowired
	private CitizenRepo cRepo;
	
	@Override
	public Citizen addCitizen(Citizen citizen) {
		
		return this.cRepo.save(citizen);
	}

	@Override
	public List<Citizen> fetchCitizenByVaccinationCentre(Integer cId) {
		List<Citizen> citizens = this.cRepo.findByVaccinationCenterId(cId);
		return citizens;
	}

}
