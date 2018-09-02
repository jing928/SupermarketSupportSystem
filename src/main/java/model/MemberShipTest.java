package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberShipTest {
	private MemberShip card;
	@Before
	public void setUp() throws Exception {
		card = new MemberShip("1234");
	}

	@Test
	public void testMemberShip() {
		assertEquals(Integer.valueOf(0), card.getPointBalance());
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
		assertEquals(200, card.getPointBalance(),0);
		assertTrue(card.earnPoints(200));
		assertEquals(400, card.getPointBalance(),0);
	}

	@Test
	public void testDeductMoney() {
		card.usePoints(card.getPointBalance());
		card.earnPoints(500);
		assertFalse(card.usePoints(-90));
		assertFalse(card.usePoints(-2));
		assertTrue(card.usePoints(200));
		assertEquals(300, card.getPointBalance(),0);
		assertTrue(card.usePoints(200));
		assertEquals(100, card.getPointBalance(),0);
	}

}
