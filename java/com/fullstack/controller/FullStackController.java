package com.fullstack.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.pojo.Employee;
import com.fullstack.service.FullStackService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class FullStackController {
	
	@Autowired
	FullStackService fullStackService;
	
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public void greeting() {
		System.out.println("Welcome");
	}
	
	@RequestMapping(value="/connectDB",method=RequestMethod.GET)
	public String connectDB() {
		return fullStackService.createDocument();
	}
	
	@RequestMapping(value="/getDocument",method=RequestMethod.GET)
	public Document getDocument() {
		return fullStackService.getDocument();
	}
	
	@RequestMapping(value = "/createDocument",method = RequestMethod.POST)
	public String createDocument(@RequestBody Employee employee) {
		return fullStackService.createNew(employee);
	}
	@RequestMapping(value = "/allDocuments",method = RequestMethod.GET)
	public List<Employee> getAll(){
		return fullStackService.getAll();
	}
	

}
