package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromotionTest {

	@Test
	public void testSetBulkQuantityForProduct() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setBulkQuantityForProduct("Apple", 3);
		promos.setBulkQuantityForProduct("Banana", 5);
		assertEquals(2, promos.getBulkQuantities().size());
	}

	@Test
	public void testSetDiscountForProduct() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setDiscountForProduct("Apple", 0.1);
		promos.setDiscountForProduct("Banana", 0.2);
		assertEquals(2, promos.getDiscounts().size());
	}
	
	@Test(expected = InvalidInputException.class)
	public void testSetBulkQuantityForProductInvalidInput() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setBulkQuantityForProduct("Apple", -1);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testSetDiscountForProductInvalidInput() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setDiscountForProduct("Apple", -0.2);
	}

	@Test
	public void testGetBulkQuantityForProduct() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setBulkQuantityForProduct("Apple", 3);
		promos.setBulkQuantityForProduct("Banana", 5);
		assertEquals(3, promos.getBulkQuantityForProduct("Apple"), 0.0001);
		assertEquals(5, promos.getBulkQuantityForProduct("Banana"), 0.0001);
	}

	@Test
	public void testGetDiscountForProduct() throws InvalidInputException {
		Promotion promos = new Promotion();
		promos.setDiscountForProduct("Apple", 0.1);
		promos.setDiscountForProduct("Banana", 0.2);
		assertEquals(0.1, promos.getDiscountForProduct("Apple"), 0.0001);
		assertEquals(0.2, promos.getDiscountForProduct("Banana"), 0.0001);
	}

}
