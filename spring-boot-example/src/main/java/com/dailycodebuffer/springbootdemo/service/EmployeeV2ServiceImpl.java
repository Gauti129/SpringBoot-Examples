package com.dailycodebuffer.springbootdemo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.springbootdemo.entity.EmployeeEntity;
import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.repository.EmployeeRepository;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, empEntity); //To copy Employee data to EmployeeEntity.
		
		employeeRepository.save(empEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> empList = employeeRepository.findAll();
		
		List<Employee> employees = empList.stream()
				.map(employeeEntity-> {
					Employee emp = new Employee();
					BeanUtils.copyProperties(employeeEntity, emp);
					return emp;
				}).collect(Collectors.toList());
								
		
		return employees;
	}

	@Override
	public Employee getEmployeesById(String id) {
		EmployeeEntity empEntity = employeeRepository.findById(id).get();//optional object implementation
		Employee emp = new Employee();
		BeanUtils.copyProperties(empEntity, emp);
		return emp;
	}

	@Override
	public String deleteEmployeesById(String id) {
		employeeRepository.deleteById(id);
		return ("Employee Deleted with id: "+id);
	}

}
