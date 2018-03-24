package com.haridass.springboot.basics.springbootin10steps.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	//To Test: http://localhost:8080/filtering-list
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean(){
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
						filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSOmeBeans(){
		
		List<SomeBean> list =  Arrays.asList(new SomeBean("value1","value2","value3"), 
				new SomeBean("value12","value22","value32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		
		return list;
		
	}

}
