
package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	private Customer customer;
	private final String id = "123";
	private final String phone = "0412345678";
	private final String name = "Jack";
	private final Location address = new Location("11", "Haha Road", "6", "Melbourne", "3000");
	private final Membership card = new Membership("123");

	@BeforeEach
	public void setUp() {
		customer = new Customer(id, name, phone, address, card);
	}

	/*
	 * test reward account
	 */
	@Test
	public void testGetRewardsAccount() {
		int points = 10;
		customer.getRewardsAccount().earnPoints(points);
		Boolean expect = customer.getRewardsAccount().getPointBalance() == (points);
		assertTrue(expect);
	}

	/*
	 * test debit card of customer
	 */
	@Test
	public void testDebitCard() {
		String cardNubmer = "3333";
		DebitCard card = new DebitCard(cardNubmer);
		customer.setDebitCard(card);
		Boolean expect = customer.getDebitCard().getCardNum().equals(cardNubmer);
		assertTrue(expect);
	}
}
