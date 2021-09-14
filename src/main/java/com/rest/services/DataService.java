package com.rest.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.util.UnluckyException;

@Service
public class DataService implements IDataService {

	 public List<String> getNames()
	 {
		 String[] names= {
				 "Arun","Kiran","John","Mohan","Shahul","Jake","Roger"
		 };
		 
		 return Arrays.asList(names);
	 }
	 
	 
	 public String  hopeForTheBest(int input) throws UnluckyException
	 {
		 String n= "Good Things Happened!!!";
		 Long data = Math.round(Math.random()*1000);
		 if(data%input ==0)
			 throw new UnluckyException();
		 return n;
	 }
}
