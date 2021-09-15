package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Person;

public interface PeopleRepository extends JpaRepository<Person, Long>{
    
	public Person findBySno(Integer sno);
}
