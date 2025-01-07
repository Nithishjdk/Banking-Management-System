package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.repo.LoanRepo;

@Repository
public class LoanDao {
	@Autowired
	LoanRepo loanRepo;

	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}

	public Loan fetchLoanById(int loanId) {
		Optional<Loan> loan = loanRepo.findById(loanId);
		if (loan.isEmpty()) {
			return null;
		}
		return loan.get();
	}

	public List<Loan> fetchAllLoan() {
		return loanRepo.findAll();
	}

	public Loan updateLoanById(int oldLoanId, Loan newLoan) {
		Optional<Loan> optional = loanRepo.findById(oldLoanId);
		if (optional.isEmpty()) {
			newLoan.setLoanId(oldLoanId);
			Loan loan = loanRepo.save(newLoan);
			return loan;
		}
		return null;
	}

	public Loan deleteLoanById(int loanId) {
		Optional<Loan> optional = loanRepo.findById(loanId);
		if (optional.isEmpty()) {
			Loan loan = fetchLoanById(loanId);
			loanRepo.delete(loan);
			return loan;
		}
		return null;
	}
}
