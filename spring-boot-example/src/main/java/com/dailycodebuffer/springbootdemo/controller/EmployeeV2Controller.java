package com.dailycodebuffer.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

	@Qualifier("employeeV2ServiceImpl")
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@GetMapping
	public List<Employee> getEmployee(){
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeesById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable String id) {
		return employeeService.deleteEmployeesById(id);
		
	}
	
}
