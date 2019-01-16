package com.qa.accountapp;
import java.util.HashMap;
import java.util.Map;

public class Service {
	private HashMap<Integer,Account> accounts = new HashMap<Integer,Account>();
	private int id = 0;

	public Service() {
	}

	public Account addAccount(Account account) {
		id++;
		account.setAccountNumber(id);
		accounts.put(id,account);	
		return account;
	}

	public Account deleteAccount(Account account) {
		accounts.remove(account.getAccountNumber(), account);
		return account;
	}

	public Account updateFirstName(Account account, String input) {
		account.setFirstName(input);
		return account;
	}

	public Account updateLastName(Account account, String input) {
		account.setLastName(input);
		return account;
	}
	
	public Account retrieveAccount(int id) {
		return accounts.get(id);
	}
	
	public int numberOfAccounts() {
		return accounts.size();
	}

	public int countByName(String name) {
		int count =0;
		for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
			int key = entry.getKey();
			if (entry.getValue().getFirstName().toLowerCase().equals(name.toLowerCase())) {
				count++;
			}
		}
		return count;
	}
}
