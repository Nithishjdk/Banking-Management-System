package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.service.LoanService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;

	@Operation(summary = "Save Loan", description = "API is used to save the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveLoan")
	public ResponseStructure<Loan> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}

	@Operation(summary = "Fetches Loan", description = "API is used to fetch the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@GetMapping("/fetchLoanById")
	public ResponseStructure<Loan> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}

	@Operation(summary = "Fetches all Loan", description = "API is used to fetch all the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@GetMapping("/fetchAllLoan")
	public ResponseStructureList<Loan> fetchAllLoan() {
		return loanService.fetchAllLoan();
	}

	@Operation(summary = "updates Loan", description = "API is used to updates the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@PutMapping("/updateLoanById")
	public ResponseStructure<Loan> updateLoanById(@RequestParam int oldLoanId, @RequestBody Loan newLoan) {
		return loanService.updateLoanById(oldLoanId, newLoan);
	}

	@Operation(summary = "deletes Loan", description = "API is used to deletes the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Loan not found for the given id") })
	@DeleteMapping("/deleteLoanById")
	public ResponseStructure<Loan> deleteLoanById(@RequestParam int loanId) {
		return loanService.deleteLoanById(loanId);
	}

}
