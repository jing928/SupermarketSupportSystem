package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesStaffTest {

	SalesStaff salesStaff;

	@BeforeEach
	public void setUp() throws Exception {
		salesStaff = new SalesStaff();
	}

	@Test
	public void testAddDebitCard() {
		Customer customer1 = new Customer("111", "abc");
		assertTrue(salesStaff.addDebitCard(customer1, 11));
		assertFalse(salesStaff.addDebitCard(customer1, -2));
	}

	@Test
	public void testTopUpDebitCard() {
		Customer customer1 = new Customer("111", "abc");
		assertTrue(salesStaff.topUpDebitCard(customer1, 11));
		assertFalse(salesStaff.topUpDebitCard(customer1, -2));
	}

}
