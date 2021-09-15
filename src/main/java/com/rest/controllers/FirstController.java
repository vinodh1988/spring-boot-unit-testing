package com.rest.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Person;
import com.rest.services.IDataService;
import com.rest.util.AlreadyExistingException;

@RestController
@RequestMapping("/api")
public class FirstController {
	
	@Autowired
	IDataService data;

	 @GetMapping("/hello")
	 public String greet() {
		 return "First Spring boot application";
	 }
	 
	 @GetMapping(value="/names")
	 public List<String> list(){
		 return data.getNames();
	 }
	 
	 @GetMapping("/people")
	 public List<Person> getPeople(){
		 return data.getPeople();
	 }
	 
	 @PostMapping("/people")
	 public ResponseEntity<Person> addPerson(@RequestBody Person person){
		 try {
		 data.add(person);
		 return  new ResponseEntity<Person>(person,HttpStatus.CREATED);
		 }
		 catch (AlreadyExistingException e) {
			// TODO: handle exception
			 return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
}
