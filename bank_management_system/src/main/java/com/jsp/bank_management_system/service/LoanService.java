package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.LoanDao;
import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.exception.LoanIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class LoanService {
	@Autowired
	LoanDao loanDao;
	@Autowired
	ResponseStructure<Loan> responseStructure;
	@Autowired
	ResponseStructureList<Loan> responseStructureList;

	public ResponseStructure<Loan> saveLoan(Loan loan) {
		responseStructure.setMessage("successfully loan inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return responseStructure;
	}

	public ResponseStructure<Loan> fetchLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("successfully loan fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.fetchLoanById(loanId));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}
	}

	public ResponseStructureList<Loan> fetchAllLoan() {
		responseStructureList.setMessage("successfully loan fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(loanDao.fetchAllLoan());
		return responseStructureList;
	}

	public ResponseStructure<Loan> updateLoanById(int oldLoanId, Loan newLoan) {
		Loan loan = loanDao.fetchLoanById(oldLoanId);
		if (loan != null) {
			responseStructure.setMessage("successfully loan updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.updateLoanById(oldLoanId, newLoan));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}
	}

	public ResponseStructure<Loan> deleteLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("successfully loan deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.deleteLoanById(loanId));
			return responseStructure;
		} else {
			throw new LoanIdNotFound();
		}
	}
}
