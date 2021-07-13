package com.covid.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid.vaccination.repository.VaccinationRepository;

@RestController
@RequestMapping("/api/vaccines")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationController {
	
	@Autowired
	VaccinationRepository vaccinationRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "index";
	}

}
