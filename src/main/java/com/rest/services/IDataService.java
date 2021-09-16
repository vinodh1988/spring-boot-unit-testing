package com.rest.services;

import java.util.List;

import com.rest.model.Person;
import com.rest.util.AlreadyExistingException;
import com.rest.util.RecordNotFoundException;
import com.rest.util.UnluckyException;

public interface IDataService {
    public List<String> getNames();
    public String  hopeForTheBest(int input) throws UnluckyException;
    public List<Person> getPeople();
    public void add(Person p) throws AlreadyExistingException;
    public void delete(Integer id) throws RecordNotFoundException;
    public void update(int id,Person p);
}
