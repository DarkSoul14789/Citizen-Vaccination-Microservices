package com.shubh.microservices.VaccinationCenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubh.microservices.VaccinationCenter.entities.VaccinationCenter;

public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
