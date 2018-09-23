package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(0.0, card.getBalance(),0.01);
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
		assertEquals(200.0, card.getBalance(),0.01);
	}

	/*
	 * test deduct money 500 - 200 = 300
	 */
	@Test
	public void testDeductMoney() {
		card.addMoney(500);
		card.deductMoney(200);
		assertEquals(300.0, card.getBalance(),0.01);
	}

}
