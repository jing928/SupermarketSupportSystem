package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MembershipTest {

	private Membership card;

	@BeforeEach
	public void setUp() throws Exception {
		card = new Membership("1234");
	}

	@Test
	public void testMemberShip() {
		assertEquals(0, card.getPointBalance());
	}

	@Test
	public void testGetCardNum() {
		assertEquals("1234", card.getCardNum());
	}

	@Test
	public void testAddMoney() {
		card.usePoints(card.getPointBalance());
		assertFalse(card.earnPoints(-90));
		assertFalse(card.earnPoints(-2));
		assertTrue(card.earnPoints(200));
		assertEquals(200, card.getPointBalance());
		assertTrue(card.earnPoints(200));
		assertEquals(400, card.getPointBalance());
	}

	@Test
	public void testDeductMoney() {
		card.usePoints(card.getPointBalance());
		card.earnPoints(500);
		assertFalse(card.usePoints(-90));
		assertFalse(card.usePoints(-2));
		assertTrue(card.usePoints(200));
		assertEquals(300, card.getPointBalance());
		assertTrue(card.usePoints(200));
		assertEquals(100, card.getPointBalance());
	}

}
