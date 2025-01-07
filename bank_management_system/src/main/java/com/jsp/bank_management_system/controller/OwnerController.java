package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Owner;
import com.jsp.bank_management_system.service.OwnerService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@Operation(summary = "Fetches Owner", description = "API is used to fetch the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@Operation(summary = "Fetches all Owner", description = "API is used to fetch all the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@Operation(summary = "updates Owner", description = "API is used to updates the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId, @RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@Operation(summary = "deletes Owner", description = "API is used to deletes the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}

	@Operation(summary = "add Existing Bank To Existing Owner", description = "API is used to add Existing Bank To Existing Owner in Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/addExistingBankToExistingOwner")
	public ResponseStructure<Owner> addExistingBankToExistingOwner(@RequestParam int bankId,
			@RequestParam int ownerId) {
		return ownerService.addExistingBankToExistingOwner(bankId, ownerId);
	}
}
