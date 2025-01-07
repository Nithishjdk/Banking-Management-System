package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.AddressDao;
import com.jsp.bank_management_system.dto.Address;
import com.jsp.bank_management_system.exception.AddressIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseStructure<Address> saveAddress(Address Address) {
		responseStructure.setMessage("successfully address inserted to database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(Address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int AddressId) {
		Address address = addressDao.fetchAddressById(AddressId);
		if (address != null) {
			responseStructure.setMessage("successfully address fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(AddressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructureList<Address> fetchAllAddress() {
		responseStructureList.setMessage("successfully all address fetched to database");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(addressDao.fetchAllAddress());
		return responseStructureList;
	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setMessage("successfully address updated in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> deleteAddressById(int AddressId) {
		Address address = addressDao.fetchAddressById(AddressId);
		if (address != null) {
			responseStructure.setMessage("successfully address deleted from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(AddressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

}
