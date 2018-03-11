package com.haridass.springboot.basics.springbootin10steps.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	//GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	//GET /users/{id}
	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable int id){
		return userDaoService.findOne(id);
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody User user){
		userDaoService.save(user);
	}
	
}
