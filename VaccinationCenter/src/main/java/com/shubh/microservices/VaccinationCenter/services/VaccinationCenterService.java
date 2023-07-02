package com.shubh.microservices.VaccinationCenter.services;

import java.util.List;

import com.shubh.microservices.VaccinationCenter.entities.VaccinationCenter;

public interface VaccinationCenterService {

	VaccinationCenter addCenter(VaccinationCenter vc);
	List<VaccinationCenter> getCenters();
	VaccinationCenter getCenter(Integer id);
	
}
