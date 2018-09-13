package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberShipTest {
	private Membership card;
	
	@Before
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
		card.earnPoints(200);
		assertEquals(200, card.getPointBalance(),0);
	}

	@Test
	public void testDeductMoney() {
		card.earnPoints(500);
		assertTrue(card.usePoints(200));
		assertEquals(300, card.getPointBalance(),0);
	}

}
