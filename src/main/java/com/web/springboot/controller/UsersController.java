package com.web.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.dao.UserRepository;
import com.web.springboot.entity.Users;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
    private UserRepository  userRepository;


	

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
    	
    	users.setRole("ROLE_USER");
    	return	userRepository.save(users);
       
    }
    
    
    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return (List<Users>) userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Users> findByName(@PathVariable final Long id){
		
	
		return userRepository.findById(id);
    }
    @GetMapping(value = "/{firstName}")
    public Users findByName(@PathVariable final String firstName){
		
	
		return userRepository.findByName(firstName);
    }
    
}
