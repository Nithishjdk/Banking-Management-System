package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Bank;
import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.service.BankService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BankController {
	@Autowired
	BankService bankService;

	@Operation(summary = "Save Bank", description = "API is used to save the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}

	@Operation(summary = "Fetches Bank", description = "API is used to fetch the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}

	@Operation(summary = "Fetches all Bank", description = "API is used to fetch all the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@GetMapping("/fetchAllBank")
	public ResponseStructureList<Bank> fetchAllBank() {
		return bankService.fetchAllBank();
	}

	@Operation(summary = "updates Bank", description = "API is used to updates the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/updateBankById")
	public ResponseStructure<Bank> updateBankById(@RequestParam int oldBankId, @RequestBody Bank newBank) {
		return bankService.updateBankById(oldBankId, newBank);
	}

	@Operation(summary = "deletes Bank", description = "API is used to deletes the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@DeleteMapping("/deleteBankById")
	public ResponseStructure<Bank> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}

	@Operation(summary = "Existing Branch To Existing Bank", description = "API is used to add Existing Branch To Existing Bank the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/addExistingBranchToExistingBank")
	public ResponseStructure<Bank> addExistingBranchToExistingBank(@RequestParam int bankId,
			@RequestParam int branchId) {
		return bankService.addExistingBranchToExistingBank(bankId, branchId);
	}

	@Operation(summary = "New Branch To Existing Bank", description = "API is used to add New Branch To Existing Bank the Bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/addNewBranchToExistingBank")
	public ResponseStructure<Bank> addNewBranchToExistingBank(@RequestParam int bankId, @RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}
}
