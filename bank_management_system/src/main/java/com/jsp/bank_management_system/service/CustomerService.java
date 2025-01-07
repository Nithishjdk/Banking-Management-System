package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.AccountDao;
import com.jsp.bank_management_system.dao.CardDao;
import com.jsp.bank_management_system.dao.CustomerDao;
import com.jsp.bank_management_system.dao.FdDao;
import com.jsp.bank_management_system.dao.LoanDao;
import com.jsp.bank_management_system.dto.Account;
import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.dto.Loan;
import com.jsp.bank_management_system.exception.AccountIdNotFound;
import com.jsp.bank_management_system.exception.CardIdNotFound;
import com.jsp.bank_management_system.exception.CustomerIdNotFound;
import com.jsp.bank_management_system.exception.FdIdNotFound;
import com.jsp.bank_management_system.exception.LoanIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	FdDao fdDao;
	@Autowired
	LoanDao loanDao;
	@Autowired
	CardDao cardDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseStructure<Customer> saveCustomer(Customer customer) {
		responseStructure.setMessage("successfully Customer inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return responseStructure;
	}

	public ResponseStructure<Customer> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructureList<Customer> fetchAllCustomer() {
		responseStructureList.setMessage("successfully Customer fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomer());
		return responseStructureList;
	}

	public ResponseStructure<Customer> updateCustomerById(int oldCustomerId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldCustomerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer update");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer delete");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(int customerId, int accountId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Account account = accountDao.fetchAccountById(accountId);
		if (customer != null && account != null) {
			responseStructure.setMessage("successfully Customer ExistingAccountToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addExistingAccountToExistingCustomer(customerId, accountId));
			return responseStructure;
		} else if (customer == null) {
			throw new CustomerIdNotFound();
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructure<Customer> addNewAccountToExistingCustomer(int customerId, Account newAccount) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer NewAccountToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addNewAccountToExistingCustomer(customerId, newAccount));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> addExistingCardToExistingCustomer(int customerId, int cardId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Card card = cardDao.fetchCardById(cardId);
		if (customer != null && card != null) {
			responseStructure.setMessage("successfully Customer ExistingCardToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addExistingCardToExistingCustomer(customerId, cardId));
			return responseStructure;
		} else if (customer == null) {
			throw new CustomerIdNotFound();
		} else {
			throw new CardIdNotFound();
		}
	}

	public ResponseStructure<Customer> addNewCardToExistingCustomer(int customerId, Card newCard) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer NewCardToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addNewCardToExistingCustomer(customerId, newCard));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> addExistingLoadToExistingCustomer(int customerId, int loanId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Loan loan = loanDao.fetchLoanById(loanId);
		if (customer != null && loan != null) {
			responseStructure.setMessage("successfully Customer ExistingLoadToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addExistingLoadToExistingCustomer(customerId, loanId));
			return responseStructure;
		} else if (customer == null) {
			throw new CustomerIdNotFound();
		} else {
			throw new LoanIdNotFound();
		}
	}

	public ResponseStructure<Customer> addNewLoanToExistingCustomer(int customerId, Loan newLoan) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer NewLoanToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addNewLoanToExistingCustomer(customerId, newLoan));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> addExistingFdToExistingCustomer(int customerId, int fdId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Fd fd = fdDao.fetchFdById(fdId);
		if (customer != null && fd != null) {
			responseStructure.setMessage("successfully Customer ExistingFdToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addExistingFdToExistingCustomer(customerId, fdId));
			return responseStructure;
		} else if (customer == null) {
			throw new CustomerIdNotFound();
		} else {
			throw new FdIdNotFound();
		}
	}

	public ResponseStructure<Customer> addNewFdToExistingCustomer(int customerId, Fd newFd) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully Customer NewFdToExistingCustomer");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.addNewFdToExistingCustomer(customerId, newFd));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}
}
