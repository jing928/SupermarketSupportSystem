package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesStaffTest {
	
	SalesStaff salesStaff;
	
	@Before
	public void setUp() throws Exception {
		salesStaff = new SalesStaff();
	}
	@Test
	public void testAddDebitCard() {
		Customer customer1=new Customer("111","abc");
		assertTrue(salesStaff.addDebitCard(customer1,11));
		assertFalse(salesStaff.addDebitCard(customer1,-2));
	}

	@Test
	public void testTopUpDebitCard() {
		Customer customer1=new Customer("111","abc");
		assertTrue(salesStaff.topUpDebitCard(customer1,11));
		assertFalse(salesStaff.topUpDebitCard(customer1,-2));
	}



}
