package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.BankDao;
import com.jsp.bank_management_system.dao.BranchDao;
import com.jsp.bank_management_system.dto.Bank;
import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.exception.BankIdNotFound;
import com.jsp.bank_management_system.exception.BranchIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class BankService {

	@Autowired
	BankDao bankDao;

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Bank> responseStructure;

	@Autowired
	ResponseStructureList<Bank> responseStructureList;

	public ResponseStructure<Bank> saveBank(Bank bank) {
		responseStructure.setMessage("successfully bank inserted to database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return responseStructure;
	}

	public ResponseStructure<Bank> fetchBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully bank fetched from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructureList<Bank> fetchAllBank() {
		responseStructureList.setMessage("successfully all bank fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAllBank());
		return responseStructureList;
	}

	public ResponseStructure<Bank> updateBankById(int oldBankId, Bank newBank) {
		Bank bank = bankDao.fetchBankById(oldBankId);
		if (bank != null) {
			responseStructure.setMessage("successfully bank updated to database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.updateBankById(oldBankId, newBank));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructure<Bank> deleteBankById(int BankId) {
		Bank bank = bankDao.fetchBankById(BankId);
		if (bank != null) {
			responseStructure.setMessage("successfully bank deleted from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.deleteBankById(BankId));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructure<Bank> addExistingBranchToExistingBank(int bankId, int branchId) {
		Bank bank = bankDao.fetchBankById(bankId);
		Branch branch = branchDao.fetchBranchById(branchId);
		if (bank != null && branch != null) {
			responseStructure.setMessage("successfully added to ExistingBranchToExistingBank in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.addExistingBranchToExistingBank(bankId, branchId));
			return responseStructure;
		} else if (bank == null) {
			throw new BankIdNotFound();
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Bank> addNewBranchToExistingBank(int bankId, Branch newBranch) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully added to NewBranchToExistingBank in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.addNewBranchToExistingBank(bankId, newBranch));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}
}
