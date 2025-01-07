package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Account;
import com.jsp.bank_management_system.repo.AccountRepo;

@Repository
public class AccountDao {
	@Autowired
	AccountRepo accountRepo;

	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	public Account fetchAccountById(int accountId) {
		Optional<Account> account = accountRepo.findById(accountId);
		if (account.isEmpty()) {
			return null;
		} else {
			return account.get();
		}

	}

	public List<Account> fetchAllAccount() {
		return accountRepo.findAll();
	}

	public Account updateAccountById(int oldAccountId, Account newAccount) {
		Optional<Account> optional = accountRepo.findById(oldAccountId);
		if (optional.isPresent()) {
			newAccount.setAccountId(oldAccountId);
			Account account = accountRepo.save(newAccount);
			return account;
		} else {
			return null;
		}
	}

	public Account deleteAccountById(int accountId) {
		Optional<Account> optional = accountRepo.findById(accountId);
		if (optional.isPresent()) {
			Account account = fetchAccountById(accountId);
			accountRepo.delete(account);
			return account;
		} else {
			return null;
		}
	}

}
