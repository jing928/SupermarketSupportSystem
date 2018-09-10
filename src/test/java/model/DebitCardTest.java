package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebitCardTest {

	private DebitCard card;

	@BeforeEach
	public void setUp() throws Exception {
		card = new DebitCard("1234");
	}

	@Test
	public void testDebitCard() {
		assertEquals(0.0, card.getBalance(), 0.01);
	}

	@Test
	public void testGetCardNum() {
		assertEquals("1234", card.getCardNum());
	}

	@Test
	public void testAddMoney() {
		card.deductMoney(card.getBalance());
		assertFalse(card.addMoney(-90));
		assertFalse(card.addMoney(-2));
		assertTrue(card.addMoney(200));
		assertEquals(200.0, card.getBalance(),0.01);
		assertTrue(card.addMoney(200));
		assertEquals(400.0, card.getBalance(),0.01);
	}

	@Test
	public void testDeductMoney() {
		card.deductMoney(card.getBalance());
		card.addMoney(500);
		assertFalse(card.deductMoney(-90));
		assertFalse(card.deductMoney(-2));
		assertTrue(card.deductMoney(200));
		assertEquals(300.0, card.getBalance(),0.01);
		assertTrue(card.deductMoney(200));
		assertEquals(100.0, card.getBalance(),0.01);
	}

}
