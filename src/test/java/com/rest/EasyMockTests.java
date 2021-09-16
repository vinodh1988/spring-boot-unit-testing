package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.controllers.FirstController;
import com.rest.model.Person;
import com.rest.services.IDataService;

@SpringBootTest
@ExtendWith(EasyMockExtension.class)
public class EasyMockTests {
	
	@TestSubject
	FirstController controller=new FirstController();
	@Mock
	IDataService service;
	

	static List<Person> list;
	
	@BeforeAll
	public static void setup() {
		list = new ArrayList<Person>();
		list.add(new Person(1,"Raj","Chennai"));
		list.add(new Person(2,"Harry","Chennai"));
	}

	@Test
	public void stayEasy() {
    
	 
	   
       EasyMock.expect(service.getPeople()).andReturn(list);
       EasyMock.replay(service);//to activate the mock
     
       assertEquals(controller.getPeople(),list);
	  
      
       
      
		
	}
}
