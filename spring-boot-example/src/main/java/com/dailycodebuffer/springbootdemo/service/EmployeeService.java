package com.dailycodebuffer.springbootdemo.service;

import java.util.List;

import com.dailycodebuffer.springbootdemo.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeesById(String id);

	String deleteEmployeesById(String id);
}
