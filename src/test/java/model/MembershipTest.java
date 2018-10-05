package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MembershipTest {
	private Membership card;

	@BeforeEach
	public void setUp() throws Exception {
		card = new Membership("123");
	}

	@Test
	public void testMemberShip() {
		assertEquals(0, card.getPointBalance());
	}

	@Test
	public void testGetCardNum() {
		assertEquals("123", card.getCardNum());
	}

	@Test
	public void testEarnPoints() {
		card.addPoints(200);
		assertEquals(200, card.getPointBalance());
	}

	@Test
	public void testUsePoints() {
		card.addPoints(500);
		assertTrue(card.deductPoints(200));
		assertEquals(300, card.getPointBalance());
	}
	
	@Test
	public void testCalculateRewardsDiscountWhenPriceGreaterThanMaxDiscount() {
		card.addPoints(110);
		double expected = 25.0;
		double actual = card.calculateRewardsDiscount(120 / 20 * 5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateRewardsDiscountWhenPriceLessThanMaxDiscount() {
		card.addPoints(110);
		double expected = 15.0;
		double actual = card.calculateRewardsDiscount(65 / 20 * 5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRedeemAll() {
		card.addPoints(105);
		card.redeemAll();
		int expected = 5;
		int actual = card.getPointBalance();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRedeem() {
		card.addPoints(105);
		card.redeem(25);
		int expected = 5;
		int actual = card.getPointBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		card.addPoints(110);
		String expected = "Loyalty points balance: 110 points.\nRedeemable for $25.00 discount.\n";
		String actual = card.toString();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

}
