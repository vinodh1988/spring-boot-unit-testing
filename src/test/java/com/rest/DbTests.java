package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.model.Person;
import com.rest.services.IDataService;
import com.rest.util.AlreadyExistingException;

@SpringBootTest
public class DbTests {
	@Autowired
	IDataService service;
	
	@ParameterizedTest
	@ValueSource(ints = { 1,2,3})
	@DisplayName("Checking Exception for already Existing Records")
	void checkException(int id) {
		  Person p=new Person();
		  p.setSno(id);
		  Exception e=assertThrows(AlreadyExistingException.class, ()->service.add(p));
		  assertEquals(e.getMessage(),"Record Already Existing");
	}
	
	@ParameterizedTest
	@DisplayName("CSV Based Test")
	@CsvFileSource(resources="/unittest.csv",numLinesToSkip = 1)
	void checkThroughCSV(int sno) {
		 Person p=new Person();
		  p.setSno(sno);
		  Exception e=assertThrows(AlreadyExistingException.class, ()->service.add(p));
		  assertEquals(e.getMessage(),"Record Already Existing");
	}
	
	

}
