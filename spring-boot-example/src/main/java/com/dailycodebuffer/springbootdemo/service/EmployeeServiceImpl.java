package com.dailycodebuffer.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dailycodebuffer.springbootdemo.error.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> employees = new ArrayList<>();

	@Override
	public Employee save(Employee employee) {
		if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() { 
		return employees;
	}

	@Override 
	public Employee getEmployeesById(String id) {
		return employees.stream()
				.filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
				.findFirst()
				//.get(); //To get emp detail
				.orElseThrow(()-> new RuntimeException("Employee Not found with Id : "+id)); //Generic exception
				//.orElseThrow(()-> new EmployeeNotFoundException("Employee Not found with Id : "+id)); // CustomException
	}

	@Override
	public String deleteEmployeesById(String id) {
		Employee empl = new Employee();
		empl = employees.stream()
				.filter(emp -> emp.getEmployeeId().equalsIgnoreCase(id))
				.findFirst()
				.get();
		employees.remove(empl);
		return ("Employee Deleted with id: "+id);
	}

}
