package com.covid.vaccination.controller;

import com.covid.vaccination.models.Vaccine;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineController {

	@Autowired
	VaccineService vaccineService;
	
	@RequestMapping(value = "/vaccine", method = RequestMethod.GET)
	public List<Vaccine> getAllVaccines(){
		return vaccineService.getAllVaccines();
	}

	@RequestMapping(value="/vaccine",method = RequestMethod.POST)
	public void addVaccine(@RequestBody Vaccine vaccine){
		vaccineService.addVaccine(vaccine);
	}

	@RequestMapping(value="/vaccine/{id}",method=RequestMethod.PUT)
	public void updateVaccine(@RequestBody Vaccine vaccine,@PathVariable String id){
		vaccineService.updateVaccine(vaccine,id);
	}

	@RequestMapping(value="/vaccine/{id}",method=RequestMethod.DELETE)
	public void deleteVaccine(@PathVariable String id){
		vaccineService.deleteVaccine(id);
	}


}
