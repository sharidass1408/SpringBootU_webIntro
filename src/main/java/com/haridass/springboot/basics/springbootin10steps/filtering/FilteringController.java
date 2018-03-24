package com.haridass.springboot.basics.springbootin10steps.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	//To Test: http://localhost:8080/filtering-list
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean(){
		 return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSOmeBeans(){
		return Arrays.asList(new SomeBean("value1","value2","value3"), 
				new SomeBean("value12","value22","value32"));
	}

}
