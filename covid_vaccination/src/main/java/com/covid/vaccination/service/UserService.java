package com.covid.vaccination.service;

import com.covid.vaccination.models.User;
import com.covid.vaccination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        List<User> userList= userRepository.getAllUsersRep();
        return userList;
    }
    
    public User getLoginDetails(String email, String password) {
        User user= userRepository.getLoginDetails(email, password);
        return user;
    }

    public User getUserById(String id) {
        int user_id=Integer.parseInt(id);
        User user = userRepository.getUserByIdRep(user_id);
        return user;
    }

    public void addUser(User user) {
        System.out.println(user.getName());
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user, String id) {
        int user_id=Integer.parseInt(id);
        userRepository.updateUserRep(user.getName(),user.getPhone_number(),user.getEmail(),user.getCounty(),user.getPassword(),user.getState(),user_id);
    }

    @Transactional
    public void deleteUser(String id) {
        int user_id=Integer.parseInt(id);
        userRepository.deleteUserRep(user_id);
    }
}
