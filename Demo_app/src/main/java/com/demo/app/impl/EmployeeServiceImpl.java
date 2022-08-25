package com.demo.app.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.app.exception.ResourceNotFoundException;
import com.demo.app.model.Employee;
import com.demo.app.repository.EmployeeRepository;
import com.demo.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public ResponseEntity<Employee> getEmployee(int empID) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = empRepo.findById(empID)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this ID:: " + empID));
		return ResponseEntity.ok().body(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(int empID, Employee employeeDetails) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = empRepo.findById(empID)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this Id::" + empID));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		final Employee updateEmployee = empRepo.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	@Override
	public Map<String, Boolean> deleteEmployee(int empID) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = empRepo.findById(empID)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:: " + empID));
		empRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
