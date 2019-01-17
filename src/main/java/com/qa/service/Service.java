package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.qa.domain.Account;
import com.qa.repository.AccountRepository;

public class Service {
	@Inject
	private HashMap<Integer, Account> accounts;
	//private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
	private int id = 0;

	
	
	public Service() {
	}

	public HashMap<Integer, Account> addAccount(Account account) {
		id++;
		account.setAccountNumber(Integer.toString(id));
		accounts.put(id, account);
		return accounts;
	}

	public HashMap<Integer, Account> deleteAccount(Account account) {
		accounts.remove(account.getAccountNumber(), account);
		return accounts;
	}

	public HashMap<Integer, Account> updateFirstName(Account account, String input) {
		account.setFirstName(input);
		return accounts;
	}

	public HashMap<Integer, Account> updateLastName(Account account, String input) {
		account.setLastName(input);
		return accounts;
	}

	public Account retrieveAccount(int id) {
		return accounts.get(id);
	}

	public int numberOfAccounts() {
		return accounts.size();
	}

	public int countByName(String name) {
		int count = 0;
		for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
			if (entry.getValue().getFirstName().equalsIgnoreCase(name)) {
				count++;
			}
		}
		System.out.println("There are: " + count + " " + name + "'s");
		return count;
	}
	
	public String getAsJSONString() {
		Gson gson = new Gson(); 
		String json = gson.toJson(accounts);
		return json;
	}
	
	
	
	@Inject
	private AccountRepository repo;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
	
}
