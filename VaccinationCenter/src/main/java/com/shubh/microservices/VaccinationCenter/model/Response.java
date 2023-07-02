package com.shubh.microservices.VaccinationCenter.model;

import java.util.List;

import com.shubh.microservices.VaccinationCenter.entities.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	private VaccinationCenter center;
	private List<Citizen> citizens;
}
