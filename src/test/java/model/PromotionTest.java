package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PromotionTest {
	
	private Promotion promos;

	@BeforeEach
	public void setUp() {
		promos = new Promotion();
	}
	
	@Test
	public void testSetBulkQuantityForProduct() throws InvalidInputException {
		promos.setBulkQuantityForProduct("Apple", 3);
		promos.setBulkQuantityForProduct("Banana", 5);
		assertEquals(2, promos.getBulkQuantities().size());
	}

	@Test
	public void testSetDiscountForProduct() throws InvalidInputException {
		promos.setDiscountForProduct("Apple", 0.1);
		promos.setDiscountForProduct("Banana", 0.2);
		assertEquals(2, promos.getDiscounts().size());
	}

	@Test
	public void testSetBulkQuantityForProductInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			promos.setBulkQuantityForProduct("Apple", -1);
		});
	}

	@Test
	public void testSetDiscountForProductInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			promos.setDiscountForProduct("Apple", -0.2);
		});
	}

	@Test
	public void testGetBulkQuantityForProduct() throws InvalidInputException {
		promos.setBulkQuantityForProduct("Banana", 5);
		assertEquals(5, promos.getBulkQuantityForProduct("Banana"), 0.0001);
	}

	@Test
	public void testGetDiscountForProduct() throws InvalidInputException {
		promos.setDiscountForProduct("Banana", 0.2);
		assertEquals(0.2, promos.getDiscountForProduct("Banana"), 0.0001);
	}

}
