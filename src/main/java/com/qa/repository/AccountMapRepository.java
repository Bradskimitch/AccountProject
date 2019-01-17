package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.qa.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {
	@Inject
	private HashMap<Long, Account> accounts;
	// private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();

	@Inject
	private JSONUtil util;

	public AccountMapRepository() {
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accounts);
	}

	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		accounts.put(anAccount.getId(), anAccount);
		return "{Account Created}";
	}

	public String deleteAccount(Long id) {
		accounts.remove(id);
		return "{Account Deleted}";
	}

	public String updateAccount(Long id, String input, String toChange) {
		Account anAccount = accounts.get(id);
		switch (toChange) {
		case "firstName":
			anAccount.setFirstName(input);
			break;
		case "lastName":
			anAccount.setLastName(input);
			break;
		case "accountNumber":
			anAccount.setAccountNumber(input);
			break;
		}
		return "{Account Updated}";
	}

	/*
	 * public HashMap<Integer, Account> addAccount(Account account) { id++;
	 * account.setId(id);
	 * 
	 * return accounts;
	 * 
	 * public HashMap<Integer, Account> deleteAccount(Account account) {
	 * 
	 * return accounts; }
	 * 
	 * public HashMap<Integer, Account> updateFirstName(Account account, String
	 * input) { account.setFirstName(input); return accounts; }
	 * 
	 * public HashMap<Integer, Account> updateLastName(Account account, String
	 * input) { account.setLastName(input); return accounts; }
	 * 
	 * public Account retrieveAccount(int id) { return accounts.get(id); }
	 * 
	 * public int numberOfAccounts() { return accounts.size(); }
	 * 
	 * public String getAsJSONString() { Gson gson = new Gson(); String json =
	 * gson.toJson(accounts); return json; }
	 */
}
