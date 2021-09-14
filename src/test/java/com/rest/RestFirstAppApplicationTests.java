package com.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.controllers.FirstController;
import com.rest.services.IDataService;
import com.rest.util.UnluckyException;

@SpringBootTest
class RestFirstAppApplicationTests {

	@Autowired
	  IDataService idata;
	
	@Autowired
	  IDataService idata3;
	
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
				     ()->assertEquals(idata.getNames().size(),7));
	  }
	  
	  @Test
	  @DisplayName("DataService must be singleton")
	  public void singletonCheck() {
		  assertEquals(idata,idata3);
	  }
	  
	  @Test
	  @DisplayName("Asserting Exception Scenario")
	  public void checkException() {
		  Exception e=assertThrows(UnluckyException.class,()->idata.hopeForTheBest(1));
		  assertEquals(e.getMessage(),"Unlucky Exception");
		  
		 /*  e=assertThrows(UnluckyException.class,()->idata.hopeForTheBest(3));
		  
		  assertEquals(e.getMessage(),"Unlucky Exception");*/
		  
	  }
}
