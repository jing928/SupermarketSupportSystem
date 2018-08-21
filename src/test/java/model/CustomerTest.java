package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;
	private String id = "001";
	private String name = "Jack";
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer(id, name);
	}

	@Test
	public void testCustomer() {
		assertEquals(id, customer.getId());
		assertEquals(name, customer.getName());
		assertTrue(customer.getAddresses().size() == 0);
		assertTrue(customer.getPhones().size() == 0);
		assertTrue(customer.getSales().size() == 0);
	}

	@Test
	public void testAddPhone() {
		assertTrue(customer.addPhone("88886666"));
		assertFalse(customer.addPhone("88886666"));
		assertFalse(customer.addPhone(null));
		assertTrue(customer.getPhones().size() == 1);
		assertEquals("88886666", customer.getPhones().get(0));
		customer.addPhone("88883333");
		assertTrue(customer.getPhones().size() == 2);
		assertEquals("88883333", customer.getPhones().get(1));
	}

	@Test
	public void testAddAddress() {
		assertTrue(customer.addAddress("Address 1"));
		assertFalse(customer.addAddress("Address 1"));
		assertFalse(customer.addAddress(null));
		
		assertTrue(customer.getAddresses().size() == 1);
		assertEquals("Address 1", customer.getAddresses().get(0));
		customer.addAddress("Address 2");
		assertTrue(customer.getAddresses().size() == 2);
		assertEquals("Address 2", customer.getAddresses().get(1));
	}

	@Test
	public void testGetRewardsAccount() {
		customer.getRewardsAccount().earnPoints(10);
		assertEquals(10, customer.getRewardsAccount().getPointBalance(),0);
	}

	@Test
	public void testDebitCard() {
		DebitCard card = new DebitCard("3333");
		assertTrue(customer.setDebitCard(card));
		assertFalse(customer.setDebitCard(null));
		assertEquals("3333",customer.getDebitCard().getCardNum());
	}
}
