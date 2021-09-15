package com.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rest.model.Person;
import com.rest.repository.PeopleRepository;
import com.rest.services.DataService;

@ExtendWith(MockitoExtension.class)
public class FirstIntegration {
	@Mock 
	PeopleRepository peopleRepo;
	@InjectMocks
	DataService service;
	@Test
	@DisplayName("Testing Service Call Flow")
    public void TestServiceCall() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1,"Raj","Chennai"));
		list.add(new Person(2,"Harry","Chennai"));
		
		when(peopleRepo.findAll()).thenReturn(list);
		List<Person> resultList=service.getPeople();
		assertTrue(resultList.size()==2);
		assertTrue(resultList.get(1).getName().contentEquals("Harry"));
		
	}

}
