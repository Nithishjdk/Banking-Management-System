package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Bank;
import com.jsp.bank_management_system.dto.Owner;
import com.jsp.bank_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	BankDao bankDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isEmpty()) {
			return null;
		}
		return owner.get();
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		Optional<Owner> optional = ownerRepo.findById(oldOwnerId);
		if (optional.isPresent()) {
			newOwner.setOwnerId(oldOwnerId);
			Owner owner = saveOwner(newOwner);
			return owner;
		}
		return null;
	}

	public Owner deleteOwnerById(int ownerId) {
		Optional<Owner> optional = ownerRepo.findById(ownerId);
		if (optional.isPresent()) {
			Owner owner = fetchOwnerById(ownerId);
			ownerRepo.delete(owner);
			return owner;
		}
		return null;
	}

	public Owner addExistingBankToExistingOwner(int bankId, int ownerId) {
		Optional<Owner> optional = ownerRepo.findById(ownerId);
		if (optional.isPresent()) {
			Bank bank = bankDao.fetchBankById(bankId);
			Owner owner = fetchOwnerById(ownerId);
			owner.setBank(bank);
			return saveOwner(owner);
		}
		return null;
	}
}
