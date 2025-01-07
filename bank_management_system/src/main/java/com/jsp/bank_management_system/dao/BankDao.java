package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Bank;
import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.repo.BankRepo;
import com.jsp.bank_management_system.repo.BranchRepo;

@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	@Autowired
	BranchDao branchDao;
	@Autowired
	BranchRepo branchRepo;

	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}

	public Bank fetchBankById(int bankId) {
		Optional<Bank> bank = bankRepo.findById(bankId);
		if (bank.isEmpty()) {
			return null;
		}
		return bank.get();
	}

	public List<Bank> fetchAllBank() {
		return bankRepo.findAll();
	}

	public Bank updateBankById(int oldBankId, Bank newBank) {
		Optional<Bank> optional = bankRepo.findById(oldBankId);
		if (optional.isPresent()) {
			newBank.setBankId(oldBankId);
			Bank bank = bankRepo.save(newBank);
			return bank;
		} else {
			return null;
		}
	}

	public Bank deleteBankById(int BankId) {
		Optional<Bank> optional = bankRepo.findById(BankId);
		if (optional.isPresent()) {
			Bank bank = fetchBankById(BankId);
			bankRepo.delete(bank);
			return bank;
		} else {
			return null;
		}
	}

	public Bank addExistingBranchToExistingBank(int bankId, int branchId) {
		Optional<Bank> optional = bankRepo.findById(bankId);
		Optional<Branch> optional1 = branchRepo.findById(branchId);
		if (optional.isPresent() && optional1.isPresent()) {
			Bank bank = fetchBankById(bankId);
			Branch branch = branchDao.fetchBranchById(branchId);
			List<Branch> list = bank.getBranchs();
			list.add(branch);
			return saveBank(bank);
		} else {
			return null;
		}
	}

	public Bank addNewBranchToExistingBank(int bankId, Branch newBranch) {
		Optional<Bank> optional = bankRepo.findById(bankId);
		if (optional.isPresent()) {
			Bank bank = fetchBankById(bankId);
			List<Branch> list = bank.getBranchs();
			list.add(newBranch);
			return saveBank(bank);
		} else {
			return null;
		}
	}

}
