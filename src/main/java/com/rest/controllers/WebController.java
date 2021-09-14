package com.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.services.IDataService;

@Controller
public class WebController {
   
	@Autowired
	IDataService data;
	@RequestMapping("/firstpage")
	public String getView(ModelMap model) {
		System.out.println("I N V O K E D");
		model.addAttribute("names",data.getNames());
		return "home";
	}
}
