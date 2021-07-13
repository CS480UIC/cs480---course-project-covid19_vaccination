package com.covid.vaccination.controller;

import com.covid.vaccination.service.CenterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineCenterController {

    private final CenterService centerService;


    public VaccineCenterController(CenterService centerService) {
        this.centerService = centerService;
    }

}
