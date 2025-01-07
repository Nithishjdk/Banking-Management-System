package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Account;
import com.jsp.bank_management_system.service.AccountService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	@Operation(summary = "Save account", description = "API is used to save the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveAccount")
	public ResponseStructure<Account> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@Operation(summary = "Fetches account", description = "API is used to fetch the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@GetMapping("/fetchAccountById")
	public ResponseStructure<Account> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}
	
	@Operation(summary = "Fetches all account", description = "API is used to fetch all the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@GetMapping("/fetchAllAccount")
	public ResponseStructureList<Account> fetchAllAccount() {
		return accountService.fetchAllAccount();
	}
	
	@Operation(summary = "updates account", description = "API is used to updates the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@PutMapping("/updateAccountById")
	public ResponseStructure<Account> updateAccountById(@RequestParam int oldAccountId,
			@RequestBody Account newAccount) {
		return accountService.updateAccountById(oldAccountId, newAccount);
	}
	
	@Operation(summary = "Save Bank", description = "API is used to deletes the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@DeleteMapping("/deleteAccountById")
	public ResponseStructure<Account> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}

}
