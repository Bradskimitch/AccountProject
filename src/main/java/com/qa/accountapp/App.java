package com.qa.accountapp;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) {

		System.out.println("Initial Commit");

		Service man = new Service();
		Account ben = new Account("Ben", "Jenkins");
		Account ben2 = new Account("Ben2", "Jenkins2");
		man.addAccount(ben);
		man.addAccount(ben2);
		System.out.println(man.retrieveAccount(1).getFirstName() + " " + man.retrieveAccount(1).getLastName());
		
		Gson gson = new Gson(); 
		String json = gson.toJson(man);
		System.out.println(json);
	}

}
