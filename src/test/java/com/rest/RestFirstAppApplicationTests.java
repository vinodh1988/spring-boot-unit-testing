package com.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.controllers.FirstController;
import com.rest.services.IDataService;

@SpringBootTest
class RestFirstAppApplicationTests {

	@Autowired
	  IDataService idata;
	
	  IDataService idata2;
	
	  
	  @Test
	  @DisplayName("Controller greet method should work")
	  public void firstTest() {
		  FirstController fc=new FirstController();
		  assertEquals(fc.greet(),"First Spring boot application" );
	  }
	  
	  
	  @Test
	  @DisplayName("Autowiring of service must work")
	  public void serviceTest() {
		  
		  assertNotNull(idata);
	  }
	  
	  
	  @Test
	  @DisplayName("Not Autowired must be null")
	  public void serviceTest2() {
		  
		  assertTrue(idata2==null);
	  }
	  
	  @Test
	  @DisplayName("Length Check")
	  public void lengthCheck() {
		  assertAll("Length Assertions",
				     ()->assertTrue(idata.getNames().size()>0),
				     ()->assertTrue(idata.getNames().size()<=20));
	  }
}
