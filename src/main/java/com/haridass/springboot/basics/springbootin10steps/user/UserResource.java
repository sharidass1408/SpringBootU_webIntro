package com.haridass.springboot.basics.springbootin10steps.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		User savedUser = userDaoService.save(user);
		// CREATED
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
}
