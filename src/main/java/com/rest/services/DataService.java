package com.rest.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataService implements IDataService {

	 public List<String> getNames()
	 {
		 String[] names= {
				 "Arun","Kiran","John","Mohan","Shahul","Jake","Roger"
		 };
		 
		 return Arrays.asList(names);
	 }
}
