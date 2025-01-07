package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.service.BranchService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Branch", description = "API is used to save the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@Operation(summary = "Fetches Branch", description = "API is used to fetch the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@Operation(summary = "Fetches all Branch", description = "API is used to fetch the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@Operation(summary = "updates Bank", description = "API is used to updates the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@Operation(summary = "deletes Branch", description = "API is used to deletes the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@Operation(summary = "add Existing Address To Existing Branch", description = "API is used to fetch the Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int branchId, @RequestParam int addressId) {
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}

	@Operation(summary = "add Existing Manager To Existing Branch", description = "API is used to add Existing Manager To Existing Branch in Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int branchId, @RequestParam int managerId) {
		return branchService.addExistingManagerToExistingBranch(branchId, managerId);
	}

	@Operation(summary = "add Existing Employee To Existing Branch", description = "API is used to add Existing Employee To Existing Branch in Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(@RequestParam int employeeId, @RequestParam int branchId) {
		return branchService.addExistingEmployeeToExistingBranch(employeeId, branchId);
	}

	@Operation(summary = "add New Employee To Existing Branch", description = "API is used to add New Employee To Existing Branch in Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(@RequestParam int branchId, @RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}

	@Operation(summary = "add Existing Customer To Existing Branch", description = "API is used to add Existing Customer To Existing Branch in Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(@RequestParam int customerId, @RequestParam int branchId) {
		return branchService.addExistingCustomerToExistingBranch(customerId, branchId);
	}

	@Operation(summary = "add New Customer To Existing Branch", description = "API is used to add New Customer To Existing Branch in Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found for the given id") })
	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(@RequestParam int branchId, @RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newCustomer);
	}

}
