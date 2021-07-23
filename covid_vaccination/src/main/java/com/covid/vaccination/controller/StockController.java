package com.covid.vaccination.controller;

import com.covid.vaccination.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StockController {

    @Autowired
    StockService stockService;

    //Complex query 1
    //Get the name of state which has highest stock of Pfizer
    @RequestMapping(value = "/stock",method = RequestMethod.GET)
    public List<String> getHighestPfizer(){
        return stockService.getHighestPfizer();
    }

    //Complex query 2
    //Get the total people in Illinois who have been vaccinated by a given vaccine.
    @RequestMapping(value="/stock/{name}",method = RequestMethod.GET)
    public List<String> sumVaccinated(@PathVariable String name){
        return stockService.getSumVaccinated(name);
    }
}