package com.demo.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Employee;
import com.demo.app.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return empService.listEmployee();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int employeeId) throws Exception {
		return empService.deleteEmployee(employeeId);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> detailsEmployee(@PathVariable(value = "id") int employeeId) throws Exception {
		return empService.getEmployee(employeeId);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int employeeId,
			@RequestBody Employee employeeDetails) throws Exception {
		return empService.updateEmployee(employeeId, employeeDetails);
	}

}
