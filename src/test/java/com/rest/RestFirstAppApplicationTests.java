package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rest.controllers.FirstController;

class RestFirstAppApplicationTests {

	
	  @Test
	  public void firstTest() {
		  FirstController fc=new FirstController();
		  assertEquals(fc.greet(),"First Spring boot application" );
	  }
}
