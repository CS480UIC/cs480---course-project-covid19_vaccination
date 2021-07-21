package com.covid.vaccination.controller;

//import com.covid.vaccination.service.CenterService;
import com.covid.vaccination.models.VaccinationCentre;
import com.covid.vaccination.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.covid.vaccination.service.VaccinationCenterService;
import java.util.List;

@RestController
@RequestMapping("/vaccinecenter")
@CrossOrigin
public class VaccineCenterController {

//    @Autowired
//    private CenterService centerService;

    @Autowired
    VaccinationCenterService vaccinationCentreService;
    @GetMapping
    public List<VaccinationCentre> getAllVaccinationCentersInState(@PathVariable String state){
        return vaccinationCentreService.getALLVaccinationCentresInState(state);
    }

    @GetMapping
    public List<VaccinationCentre> getAllCentersQuery(){
        return vaccinationCentreService.getALlVaccinationCentersQuery();
    }



}
