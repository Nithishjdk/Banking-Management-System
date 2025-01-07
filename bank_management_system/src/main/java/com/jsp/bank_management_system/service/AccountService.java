package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.AccountDao;
import com.jsp.bank_management_system.dto.Account;
import com.jsp.bank_management_system.exception.AccountIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	ResponseStructure<Account> responseStructure;
	@Autowired
	ResponseStructureList<Account> responseStructureList;

	public ResponseStructure<Account> saveAccount(Account account) {
		responseStructure.setMessage("successfully Account inserted in database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure;
	}

	public ResponseStructure<Account> fetchAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("successfully Account fetched from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(accountDao.fetchAccountById(accountId));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructureList<Account> fetchAllAccount() {
		responseStructureList.setMessage("successfully All Account fetched");
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setData(accountDao.fetchAllAccount());
		return responseStructureList;
	}

	public ResponseStructure<Account> updateAccountById(int oldAccountId, Account newAccount) {
		Account account = accountDao.fetchAccountById(oldAccountId);
		if (account != null) {
			responseStructure.setMessage("successfully Account updated in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.updateAccountById(oldAccountId, newAccount));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructure<Account> deleteAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("successfully Account deleted in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.deleteAccountById(accountId));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}
}
