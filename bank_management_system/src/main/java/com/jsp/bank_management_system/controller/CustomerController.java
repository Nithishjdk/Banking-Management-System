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
import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.service.CustomerService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@Operation(summary = "Save Customer", description = "API is used to save the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@Operation(summary = "Fetches Customer", description = "API is used to fetch the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	@Operation(summary = "Fetches all Customer", description = "API is used to fetch all the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@GetMapping("/fetchAllCustomer")
	public ResponseStructureList<Customer> fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}

	@Operation(summary = "updates Customer", description = "API is used to updates the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/updateCustomerById")
	public ResponseStructure<Customer> updateCustomerById(@RequestParam int oldCustomerId,
			@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldCustomerId, newCustomer);
	}

	@Operation(summary = "deletes Customer", description = "API is used to deletes the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@DeleteMapping("/deleteCustomerById")
	public ResponseStructure<Customer> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}

	@Operation(summary = "add Existing Account To Existing Customer", description = "API is used to add Existing Account To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(@RequestParam int customerId,
			@RequestParam int accountId) {
		return customerService.addExistingAccountToExistingCustomer(customerId, accountId);
	}

	@Operation(summary = "add New Account To Existing Customer", description = "API is used to add New Account To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int customerId,
			@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(customerId, newAccount);
	}

	@Operation(summary = "add Existing Card To Existing Customer", description = "API is used to add Existing Card To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(@RequestParam int customerId,
			@RequestParam int cardId) {
		return customerService.addExistingCardToExistingCustomer(customerId, cardId);
	}

	@Operation(summary = "add New Card To Existing Customer", description = "API is used to add New Card To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addNewCardToExistingCustomer")
	public ResponseStructure<Customer> addNewCardToExistingCustomer(@RequestParam int customerId,
			@RequestBody Card newCard) {
		return customerService.addNewCardToExistingCustomer(customerId, newCard);
	}

	@Operation(summary = "add Existing Loan To Existing Customer", description = "API is used to add Existing Loan To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(@RequestParam int customerId,
			@RequestParam int loanId) {
		return customerService.addExistingLoadToExistingCustomer(customerId, loanId);
	}

	@Operation(summary = "add New Loan To Existing Customer", description = "API is used to add New Loan To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(@RequestParam int customerId,
			@RequestBody Loan newLoan) {
		return customerService.addNewLoanToExistingCustomer(customerId, newLoan);
	}

	@Operation(summary = "add Existing Fd To Existing Customer", description = "API is used to add Existing Fd To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addExistingFdToExistingCustomer")
	public ResponseStructure<Customer> addExistingFdToExistingCustomer(@RequestParam int customerId,
			@RequestParam int fdId) {
		return customerService.addExistingFdToExistingCustomer(customerId, fdId);
	}

	@Operation(summary = "add New Fd To Existing Customer", description = "API is used to add New Fd To Existing Customer in Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Customer not found for the given id") })
	@PutMapping("/addNewFdToExistingCustomer")
	public ResponseStructure<Customer> addNewFdToExistingCustomer(@RequestParam int customerId, @RequestBody Fd newFd) {
		return customerService.addNewFdToExistingCustomer(customerId, newFd);
	}
}
