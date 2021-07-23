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
    @RequestMapping(value = "/",method=RequestMethod.GET)
    public List<VaccinationCentre> getAllVaccinationCentersInState(@PathVariable String state){
        return vaccinationCentreService.getALLVaccinationCentresInState(state);
    }

    @RequestMapping(value = "/vaccinecenter/all",method=RequestMethod.GET)
    public List<VaccinationCentre> getAllCentersQuery(){
        return vaccinationCentreService.getALlVaccinationCentersQuery();
    }

    @RequestMapping(value = "/vaccinecenter/less",method=RequestMethod.GET)
    public List<VaccinationCentre> getLessVaccinatedQuery(){
        return vaccinationCentreService.getLessVaccinatedQuery();
    }

    @RequestMapping(value = "/vaccinecenter/{state}",method=RequestMethod.GET)
    public List<VaccinationCentre> getCountyHighestState(String state){
        return vaccinationCentreService.getCountyHighestState(state);
    }






}
