import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.qa.accountapp.Account;
import com.qa.accountapp.Service;

public class AccountAppTester {
	Service man = new Service();
	Account ben = new Account("Ben", "Jenkins");
	Account ben2 = new Account("Ben2", "Jenkins2");
	
	
	@Before
	public void setup() {
	man.addAccount(ben);	
	}
	
	@Test
	public void testAddAccount() {
		man.addAccount(ben2);
		assertEquals(2,man.numberOfAccounts());
	}
	
	@Test
	public void testDeleteAccount() {
		man.deleteAccount(ben);
		assertEquals(0,man.numberOfAccounts());
	}
	
	@Test
	public void testUpdateFirstName() {
		man.updateFirstName(ben, "tim");
		assertEquals("tim",ben.getFirstName());
	}
	@Test
	public void testUpdateLastName() {
		man.updateLastName(ben, "tim");
		assertEquals("tim",ben.getLastName());
	}
	@Test
	public void testRetrieveAccount() {
		assertEquals(ben,man.retrieveAccount(ben.getAccountNumber()));
	}
	
}
