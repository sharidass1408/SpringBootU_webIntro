package com.haridass.springboot.basics.springbootin10steps.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*; 

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	//GET /users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	//GET /users/{id}
	//To test this use below url
	// http://localhost:8080/jpa/user/101/posts
	@GetMapping("/jpa/user/{id}/posts")
	public List<Post> retrieveUser(@PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("id -" + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User savedUser = userRepository.save(user);
		// CREATED
		// /user/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
		
		Optional<User> userOptional = userRepository.findById(id);
		
		
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("id -" + id);
		}
		
		User user = userOptional.get();
		
		post.setUser(user);
		
		Post savedPost =  postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
		
	}
	
	
	
}
