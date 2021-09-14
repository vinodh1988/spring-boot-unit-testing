package com.rest.services;

import java.util.List;

import com.rest.util.UnluckyException;

public interface IDataService {
    public List<String> getNames();
    public String  hopeForTheBest(int input) throws UnluckyException;
}
