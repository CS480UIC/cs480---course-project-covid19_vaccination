package com.covid.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.vaccination.entity.VaccinationEntity;



public interface VaccinationRepository extends JpaRepository<VaccinationEntity, Integer> {
	
	

}