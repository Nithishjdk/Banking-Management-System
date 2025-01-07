package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Manager;
import com.jsp.bank_management_system.service.ManagerService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@Operation(summary = "Save Manager", description = "API is used to save the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@Operation(summary = "Fetches Manager", description = "API is used to fetch the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@GetMapping("/fetchManagerbyId")
	public ResponseStructure<Manager> fetchManagerbyId(@RequestParam int managerId) {
		return managerService.fetchManagerbyId(managerId);
	}

	@Operation(summary = "Fetches all Manager", description = "API is used to fetch all the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@GetMapping("/fetchAllManager")
	public ResponseStructureList<Manager> fetchAllManager() {
		return managerService.fetchAllManager();
	}

	@Operation(summary = "updates Manager", description = "API is used to updates the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@PutMapping("/updateManagerbyId")
	public ResponseStructure<Manager> updateManagerbyId(@RequestParam int oldManagerId,
			@RequestBody Manager newManager) {
		return managerService.updateManagerbyId(oldManagerId, newManager);
	}

	@Operation(summary = "deletes Manager", description = "API is used to deletes the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@DeleteMapping("/deleteManagerById")
	public ResponseStructure<Manager> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}
}
