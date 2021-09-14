package com.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Person;
import com.rest.services.IDataService;

@RestController
@RequestMapping("/api")
public class FirstController {
	
	@Autowired
	IDataService data;

	 @GetMapping("/hello")
	 public String greet() {
		 return "First Spring boot application";
	 }
	 
	 @GetMapping("/names")
	 public List<String> list(){
		 return data.getNames();
	 }
	 
	 @GetMapping("/people")
	 public List<Person> getPeople(){
		 return data.getPeople();
	 }
}
