package com.covid.vaccination.controller;

import com.covid.vaccination.models.User;
import com.covid.vaccination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userservice.getALlUsers();
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public User getUserById(@PathVariable String id){

        return userservice.getUserById(id);

    }

    @RequestMapping(value="/user",method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userservice.addUser(user);

    }

    @RequestMapping(value = "/user/{id}",method=RequestMethod.PUT)
    public void updateUser(@RequestBody User user,@PathVariable String id){
        userservice.updateUser(user,id);

    }
    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userservice.deleteUser(id);
    }



}
