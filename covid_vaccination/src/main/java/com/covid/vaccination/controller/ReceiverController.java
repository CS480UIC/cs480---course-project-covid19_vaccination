package com.covid.vaccination.controller;

import com.covid.vaccination.models.Receiver;
import com.covid.vaccination.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Receiver Controller*/

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    //get all receivers
    @RequestMapping(value="/receiver",method= RequestMethod.GET)
    public List<Receiver> getAllReceivers(){
        return receiverService.getAllReceivers();
    }

    //add the receiver
    @RequestMapping(value="/receiver",method=RequestMethod.POST)
    public void addReceiver(@RequestBody Receiver receiver){
        receiverService.addReceiver(receiver);
    }

    //update receiver given id
    @RequestMapping(value="/receiver/{id}",method=RequestMethod.PUT)
    public void updateReceiver(@RequestBody Receiver receiver,@PathVariable String id){
        receiverService.updateReceiver(receiver,id);
    }

    //delete receiver given string id
    @RequestMapping(value="/receiver/{id}",method=RequestMethod.DELETE)
    public void deleteReceiver(@PathVariable String id){
        receiverService.deleteReceiver(id);
    }


}
