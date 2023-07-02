package com.shubh.microservices.CitizenService.service;

import java.util.List;

import com.shubh.microservices.CitizenService.entity.Citizen;

public interface CService {
	
	Citizen addCitizen(Citizen citizen);
	List<Citizen> fetchCitizenByVaccinationCentre(Integer cId);
}
