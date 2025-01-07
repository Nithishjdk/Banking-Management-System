package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Account;
import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.repo.AccountRepo;
import com.jsp.bank_management_system.repo.CardRepo;
import com.jsp.bank_management_system.repo.CustomerRepo;
import com.jsp.bank_management_system.repo.FdRepo;
import com.jsp.bank_management_system.repo.LoanRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AccountDao accountDao;
	@Autowired
	CardDao cardDao;
	@Autowired
	LoanDao loanDao;
	@Autowired
	FdDao fdDao;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CardRepo cardRepo;
	@Autowired
	FdRepo fdRepo;
	@Autowired
	LoanRepo loanRepo;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		if (customer.isEmpty()) {
			return null;
		}
		return customer.get();
	}

	public List<Customer> fetchAllCustomer() {
		return customerRepo.findAll();
	}

	public Customer updateCustomerById(int oldCustomerId, Customer newCustomer) {
		Optional<Customer> optional = customerRepo.findById(oldCustomerId);
		if (optional.isPresent()) {
			newCustomer.setCustomerId(oldCustomerId);
			Customer customer = customerRepo.save(newCustomer);
			return customer;
		}
		return null;
	}

	public Customer deleteCustomerById(int customerId) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			customerRepo.delete(customer);
			return customer;
		}
		return null;
	}

	public Customer addExistingAccountToExistingCustomer(int customerId, int accountId) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		Optional<Account> optional2 = accountRepo.findById(accountId);
		if (optional.isPresent() && optional2.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			Account account = accountDao.fetchAccountById(accountId);
			List<Account> list = customer.getAccounts();
			list.add(account);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addNewAccountToExistingCustomer(int customerId, Account newAccount) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			List<Account> list = customer.getAccounts();
			list.add(newAccount);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addExistingCardToExistingCustomer(int customerId, int cardId) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		Optional<Card> optional2 = cardRepo.findById(cardId);
		if (optional.isPresent() && optional2.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			Card card = cardDao.fetchCardById(cardId);
			List<Card> list = customer.getCards();
			list.add(card);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addNewCardToExistingCustomer(int customerId, Card newCard) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			List<Card> list = customer.getCards();
			list.add(newCard);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addExistingLoadToExistingCustomer(int customerId, int loanId) {
		Optional<Loan> optional1 = loanRepo.findById(loanId);
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent() && optional1.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			Loan loan = loanDao.fetchLoanById(loanId);
			List<Loan> list = customer.getLoans();
			list.add(loan);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addNewLoanToExistingCustomer(int customerId, Loan newLoan) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			List<Loan> list = customer.getLoans();
			list.add(newLoan);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addExistingFdToExistingCustomer(int customerId, int fdId) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		Optional<Fd> optional2 = fdRepo.findById(fdId);
		if (optional.isPresent() && optional2.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			Fd fd = fdDao.fetchFdById(fdId);
			List<Fd> list = customer.getFds();
			list.add(fd);
			return saveCustomer(customer);
		}
		return null;
	}

	public Customer addNewFdToExistingCustomer(int customerId, Fd newFd) {
		Optional<Customer> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			Customer customer = fetchCustomerById(customerId);
			List<Fd> list = customer.getFds();
			list.add(newFd);
			return saveCustomer(customer);
		}
		return null;
	}
}
