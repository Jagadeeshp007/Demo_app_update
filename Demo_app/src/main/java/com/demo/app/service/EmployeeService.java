package com.demo.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.demo.app.model.Employee;

public interface EmployeeService {

	List<Employee> listEmployee();

	Employee addEmployee(Employee employee);

	ResponseEntity<Employee> getEmployee(int empID) throws Exception;

	ResponseEntity<Employee> updateEmployee(int empID, Employee employeeDetailss) throws Exception;

	Map<String, Boolean> deleteEmployee(int empID) throws Exception;
}
