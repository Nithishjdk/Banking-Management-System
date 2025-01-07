package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.service.EmployeeService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "Save Employee", description = "API is used to save the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@Operation(summary = "Fetches Employee", description = "API is used to fetch the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}

	@Operation(summary = "Fetches all Employee", description = "API is used to fetch all the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@GetMapping("/fetchAllEmployee")
	public ResponseStructureList<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}

	@Operation(summary = "updates Employee", description = "API is used to updates the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@PutMapping("/updateEmployeeById")
	public ResponseStructure<Employee> updateEmployeeById(@RequestParam int oldEmployeeId,
			@RequestBody Employee newEmployee) {
		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}

	@Operation(summary = "deletes Employee", description = "API is used to deletes the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@DeleteMapping("/deleteEmployeeById")
	public ResponseStructure<Employee> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

}
