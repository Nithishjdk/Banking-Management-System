package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> optional = employeeRepo.findById(employeeId);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Optional<Employee> optional = employeeRepo.findById(oldEmployeeId);
		if (optional.isPresent()) {
			newEmployee.setEmployeeId(oldEmployeeId);
			Employee employee = employeeRepo.save(newEmployee);
			return employee;
		}
		return null;
	}

	public Employee deleteEmployeeById(int employeeId) {
		Optional<Employee> optional = employeeRepo.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = fetchEmployeeById(employeeId);
			employeeRepo.delete(employee);
			return employee;
		}
		return null;
	}
}
