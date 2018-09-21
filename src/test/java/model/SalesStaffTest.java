package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalesStaffTest {

	private SalesStaff salesStaff;
	private Customer customer;
	private DebitCard debitcard;

	@BeforeEach
	public void setUp() {
		salesStaff = new SalesStaff("E001", "Jane", 'F');
	}

	@Test
	public void testAddDebitCard() {
		// Fixtures
		customer = new Customer("111", "abc");
		debitcard = new DebitCard("654321");
		customer.setDebitCard(debitcard);
		debitcard.addMoney(1000.0);
		// Actions
		salesStaff.addDebitCard(customer, 1000.0, debitcard);
		// Actual Result
		double actualBalance = customer.getDebitCard().getBalance();
		// Expected Result
		double exceptedBalance = 1000.0;
		// Assertions
		assertEquals(actualBalance, exceptedBalance);

	}

	@Test
	public void testTopUpDebitCard() {
		// Fixtures
		debitcard = new DebitCard("123456");
		debitcard.addMoney(500.0);
		// Actions
		salesStaff.topUpDebitCard(debitcard, 1000.0);
		// Actual Result
		double actualBalance = debitcard.getBalance();
		// Expected Result
		double exceptedBalance = 1500.0;
		// Assertions
		assertEquals(actualBalance, exceptedBalance);

	}

}
