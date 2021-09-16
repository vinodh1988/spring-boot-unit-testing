package com.rest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.rest.model.Person;

@SpringBootTest(classes=RestFirstAppApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PeopleIntegrationTests {
   @LocalServerPort
   private int port;
   
   @Autowired TestRestTemplate restTemplate;
   /*
   @Test
   @Order(1)
   public void testPeople()
   {
	 Person[] p= restTemplate.getForObject("http://localhost:"+port+"/api/people", Person[].class);
	 
	 
	 assertThat(p[0].getName()).isEqualTo("Raj");
	 assertThat(p.length).isEqualTo(9);
	   
   }
   
   @Test
   @Order(2)
   public void testAddPerson() {
	   Person p=new Person(11,"John","Mumbai");
	   ResponseEntity<Person> response=
			   this.restTemplate.postForEntity("http://localhost:"+port+"/api/people", p, Person.class);
	   assertThat(response.getBody().getName()).isEqualTo("John");
	   assertEquals(response.getStatusCodeValue(), 201);
   }*/
   
}