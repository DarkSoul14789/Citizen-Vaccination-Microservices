package com.shubh.microservices.VaccinationCenter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.microservices.VaccinationCenter.entities.VaccinationCenter;
import com.shubh.microservices.VaccinationCenter.repositories.VaccinationCenterRepo;
import com.shubh.microservices.VaccinationCenter.services.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	private VaccinationCenterRepo vcRepo;
	
	@Override
	public VaccinationCenter addCenter(VaccinationCenter vc) {
		VaccinationCenter vaccinationCenter = this.vcRepo.save(vc);
		return vaccinationCenter;
	}

	@Override
	public List<VaccinationCenter> getCenters() {
		List<VaccinationCenter> centers = this.vcRepo.findAll();
		return centers;
	}

	@Override
	public VaccinationCenter getCenter(Integer id) {
		VaccinationCenter vaccinationCenter = this.vcRepo.findById(id).get();
		return vaccinationCenter;
	}

}
