package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebitCardTest {
	private final String cardNumber = "1234";
	private DebitCard card;

	@BeforeEach
	public void setUp() throws Exception {
		card = new DebitCard(cardNumber);
	}

	/*
	 * the balance of a new debit card shoud be zero
	 */
	@Test
	public void testDebitCard() {
		assertEquals(100.0, card.getBalance());
	}

	/*
	 * the card number should be the equals to the one be set
	 */
	@Test
	public void testGetCardNum() {
		assertEquals(cardNumber, card.getCardNum());
	}

	/*
	 * test add money
	 */
	@Test
	public void testAddMoney() {
		card.addMoney(200);
		assertEquals(300.0, card.getBalance());
	}

	/*
	 * test deduct money 500 - 200 = 300
	 */
	@Test
	public void testDeductMoney() {
		card.addMoney(500);
		card.deductMoney(200);
		assertEquals(400.0, card.getBalance());
	}

	@Test
	public void testToString() {
		card.addMoney(110.347);
		String expected = "The balance for card number 1234: $210.35\n";
		String actual = card.toString();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

}
