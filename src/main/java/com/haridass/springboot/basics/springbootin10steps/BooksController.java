package com.haridass.springboot.basics.springbootin10steps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book(11,"Midnight with the Mistic","Sadhguru"));
		return bookList;		
	}

}
