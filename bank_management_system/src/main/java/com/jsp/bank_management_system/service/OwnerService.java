package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.BankDao;
import com.jsp.bank_management_system.dao.OwnerDao;
import com.jsp.bank_management_system.dto.Bank;
import com.jsp.bank_management_system.dto.Owner;
import com.jsp.bank_management_system.exception.BankIdNotFound;
import com.jsp.bank_management_system.exception.OwnerIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	BankDao bankDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;

	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setMessage("successfully Owner inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully Owner fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructureList<Owner> fetchAllOwner() {
		responseStructureList.setMessage("successfully Owner fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(ownerDao.fetchAllOwner());
		return responseStructureList;
	}

	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if (owner != null) {
			responseStructure.setMessage("successfully Owner updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully Owner deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructure<Owner> addExistingBankToExistingOwner(int bankId, int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Bank bank = bankDao.fetchBankById(bankId);
		if (owner != null && bank != null) {
			responseStructure.setMessage("successfully Owner ExistingBankToExistingOwner");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.addExistingBankToExistingOwner(bankId, ownerId));
			return responseStructure;
		} else if (owner == null) {
			throw new OwnerIdNotFound();
		} else {
			throw new BankIdNotFound();
		}
	}
}
