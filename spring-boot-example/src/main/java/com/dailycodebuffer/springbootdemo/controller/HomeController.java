package com.dailycodebuffer.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.springbootdemo.model.User;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	//@RequestMapping(value="/user", method= RequestMethod.GET) is replaced by GetMapping
	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setId("1");
		user.setName("Steve");
		user.setEmail("steve@gmail.com");
		return user;
	}
	
	
	//@PathVariable("id2") --> to assign this value in name field.
	@GetMapping("/{id}/{id2}")
	public String pathVariable(@PathVariable String id, @PathVariable("id2") String name ) {
		return "Path Variable is:- "+id+" : "+name;
	}
	
	
	//URL: http://localhost:8085/requestParam?name=gautam&email=test
	@GetMapping("/requestParam")
	public String requestParam(@RequestParam String name,
			@RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
		return "Request Param name is:- " + name + " and EmailId is:- " + emailId;
	}
	
	//required = false, --> to make it is non-madatory
	//@RequestParam(name = "email", required = false, defaultValue = "") String emailId) --> in uri email needs to passed instead of emailId.
}
