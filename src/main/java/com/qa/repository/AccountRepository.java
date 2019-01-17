package com.qa.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String input, String toChange);

}