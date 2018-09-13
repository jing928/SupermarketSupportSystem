
package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	private final String id = "001";
	private final String name = "Jack";
	
	/*
	 * test constructor
	 * after a customer constructed, the id and name should be set correctly
	 */
	@Test
	public void testCustomer1() {
		Customer customer = new Customer(id, name);
		
		Boolean expect = id.equals(customer.getId()) &&
				name.equals(customer.getName());
		
		assertTrue(expect);
	}
	
	/*
	 * test phone of customer
	 */
	@Test
	public void testAddPhone() {
		Customer customer = new Customer(id, name);
		String phone1 = "88886666";
		customer.addPhone(phone1);

		Boolean expect = customer.getPhones().size() == 1 && 
				customer.getPhones().get(0).equals(phone1);
		
		assertTrue(expect);
	}

	/*
	 * test address of customer
	 */
	@Test
	public void testAddAddress() {
		Customer customer = new Customer(id, name);
		String address1 = "Address 1";
		customer.addAddress(address1);
		
		Boolean expect = customer.getAddresses().size() == 1 && 
				customer.getAddresses().get(0).equals(address1);
		
		assertTrue(expect);
	}

	/*
	 * test reward account
	 */
	@Test
	public void testGetRewardsAccount() {
		Customer customer = new Customer(id, name);
		int points = 10;
		customer.getRewardsAccount().earnPoints(points);
		
		Boolean expect = customer.getRewardsAccount().getPointBalance() == (points);
		
		assertTrue(expect);
	}

	/*
	 * test debit card of customer
	 */
	@Test
	public void testDebitCard() {
		Customer customer = new Customer(id, name);
		String cardNubmer = "3333";
		DebitCard card = new DebitCard(cardNubmer);
		customer.setDebitCard(card);
		
		Boolean expect = customer.getDebitCard().getCardNum().equals(cardNubmer);
		
		assertTrue(expect);
	}
}
