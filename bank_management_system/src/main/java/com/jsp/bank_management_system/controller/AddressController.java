package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Address;
import com.jsp.bank_management_system.service.AddressService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address Address) {
		return addressService.saveAddress(Address);
	}

	@Operation(summary = "Fetches Address", description = "API is used to fetch the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int AddressId) {
		return addressService.fetchAddressById(AddressId);
	}

	@Operation(summary = "Fetches all Address", description = "API is used to fetch all the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

	@Operation(summary = "updates Address", description = "API is used to updates the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,
			@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}

	@Operation(summary = "deletes Address", description = "API is used to deletes the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "account not found for the given id") })
	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

}
