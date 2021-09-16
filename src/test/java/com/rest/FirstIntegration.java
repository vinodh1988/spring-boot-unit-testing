package com.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rest.controllers.FirstController;
import com.rest.model.Person;
import com.rest.repository.PeopleRepository;
import com.rest.services.DataService;
import com.rest.util.RecordNotFoundException;
class TestTemp{
	public static String now;
}
@ExtendWith(MockitoExtension.class)
public class FirstIntegration {
	@Mock 
	PeopleRepository peopleRepo;
	@Mock
	DataService service2;
	@InjectMocks
	FirstController controller;
	@InjectMocks
	DataService service;
	
	
static	List<Person> list;
	
	@BeforeAll
	public static void setup() {
		list = new ArrayList<Person>();
		list.add(new Person(1,"Raj","Chennai"));
		list.add(new Person(2,"Harry","Chennai"));
	}
	
	@Test
	@DisplayName("Testing Service Call Flow")
    public void testServiceCall() {
		
		
		when(peopleRepo.findAll()).thenReturn(list);
		
		List<Person> resultList=service.getPeople();
		assertTrue(resultList.size()==2);
		assertTrue(resultList.get(1).getName().contentEquals("Harry"));
		
	}
	
	
	
	@Test
	@DisplayName("Testing Controller Flow")
	public void testControllerCall() {
		
		when(service2.getPeople()).thenReturn(list);
		List<Person> resultList=controller.getPeople();
	    System.out.println(resultList.size());
		assertTrue(resultList.size()==2);
		assertTrue(resultList.get(1).getName().contentEquals("Harry"));
		
	}
	
	@Test
	@DisplayName("Testing Read Operation")
	public void testReadAll() {
	try {
		MockHttpServletRequest request=new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Person person=new Person(1,"Rahul","Chennai");
		
		//when(peopleRepo.findBySno(any(Integer.class))).thenReturn(null);
		//when(peopleRepo.save(any(Person.class))).thenReturn(person);
		
	    doAnswer((i)->{
	       System.out.println("############"+i);
	       System.out.println(i);
	    	return null;
	    }).when(service2).add(person);
	    
	    
		
		ResponseEntity<Person> result=controller.addPerson(person);
	
		assertThat(result.getStatusCodeValue()).isEqualTo(201);
		assertThat(result.getBody().getName()).isEqualTo("Rahul");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	@Test
	@DisplayName("DeleteTesting for 204")
	public void deleteRecord() {
		try {
			MockHttpServletRequest request=new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
	       
			
			doAnswer((e)->{
				return null;
			}).when(service2).delete(1);
			
		 ResponseEntity<Person> result=controller.deletePerson(1);
		 //assertEquals(TestTemp.now, "deleted");
		 assertThat(result.getStatusCodeValue()).isEqualTo(204);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


   @Test
   @DisplayName("Delete Test Exception Test")
   public void deleteTest() throws RecordNotFoundException {

		MockHttpServletRequest request=new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	
	   doAnswer((i)->{
		   System.out.println(i.toString());
		   System.out.println(i.toString().contentEquals("service2.delete(1);"));
		   
		   if(i.toString().contentEquals("service2.delete(1);"))
		        return null;
	       else
	    	   throw new RecordNotFoundException();
	   }).when(service2).delete(any(Integer.class));
		 ResponseEntity<Person> result=controller.deletePerson(1);//to test success
		 //assertEquals(TestTemp.now, "deleted");
		 assertThat(result.getStatusCodeValue()).isEqualTo(204);
		 result=controller.deletePerson(2); //to test failure
		 //assertEquals(TestTemp.now, "deleted");
		 assertThat(result.getStatusCodeValue()).isEqualTo(500);
		 result=controller.deletePerson(3); //to test failure
		 //assertEquals(TestTemp.now, "deleted");
		 assertThat(result.getStatusCodeValue()).isEqualTo(500);
		 
		 Mockito.verify(service2,times(3)).delete(any(Integer.class));
   }

}
