package com.shubh.microservices.CitizenService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubh.microservices.CitizenService.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer id);
}
