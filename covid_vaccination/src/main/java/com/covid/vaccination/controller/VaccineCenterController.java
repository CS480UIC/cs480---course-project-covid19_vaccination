package com.covid.vaccination.controller;

import com.covid.vaccination.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineCenterController {

    @Autowired
    private CenterService centerService;

    public void getAllVaccines(){

    }



}
