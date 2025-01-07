package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.service.FdService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FdController {
	@Autowired
	FdService fdService;

	@Operation(summary = "Save Fd", description = "API is used to save the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveFd")
	public ResponseStructure<Fd> saveFd(@RequestBody Fd fd) {
		return fdService.saveFd(fd);
	}

	@Operation(summary = "Fetches Fd", description = "API is used to fetch the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Fd not found for the given id") })
	@GetMapping("/fetchFdById")
	public ResponseStructure<Fd> fetchFdById(@RequestParam int fdId) {
		return fdService.fetchFdById(fdId);
	}

	@Operation(summary = "Fetches all Fd", description = "API is used to fetch all the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Fd not found for the given id") })
	@GetMapping("/fetchAllFd")
	public ResponseStructureList<Fd> fetchAllFd() {
		return fdService.fetchAllFd();
	}

	@Operation(summary = "updates Fd", description = "API is used to updates the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Fd not found for the given id") })
	@PutMapping("/updateFdById")
	public ResponseStructure<Fd> updateFdById(@RequestParam int oldFdId, @RequestBody Fd newFd) {
		return fdService.updateFdById(oldFdId, newFd);
	}

	@Operation(summary = "deletes Fd", description = "API is used to deletes the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Fd not found for the given id") })
	@DeleteMapping("/deleteFdById")
	public ResponseStructure<Fd> deleteFdById(@RequestParam int fdId) {
		return fdService.deleteFdById(fdId);
	}

}
