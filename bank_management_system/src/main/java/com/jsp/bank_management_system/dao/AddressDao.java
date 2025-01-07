package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Address;
import com.jsp.bank_management_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address Address) {
		return addressRepo.save(Address);
	}

	public Address fetchAddressById(int AddressId) {
		Optional<Address> addressOptional = addressRepo.findById(AddressId);
		if (addressOptional.isPresent()) {
			return addressOptional.get();
		} else {
			return null;
		}
	}

	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}

	public Address updateAddressById(int oldAddressId, Address newAddress) {
		Optional<Address> addressOptional = addressRepo.findById(oldAddressId);
		if (addressOptional.isPresent()) {
			newAddress.setAddressId(oldAddressId);
			Address Address = addressRepo.save(newAddress);
			return Address;
		} else {
			return null;
		}
	}

	public Address deleteAddressById(int AddressId) {
		Optional<Address> addressOptional = addressRepo.findById(AddressId);
		if (addressOptional.isPresent()) {
			Address Address = fetchAddressById(AddressId);
			addressRepo.delete(Address);
			return Address;
		} else {
			return null;
		}
	}

}
