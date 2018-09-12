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
		int expected = 2;
		int actual = promos.getBulkQuantities().size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDiscountForProduct() throws InvalidInputException {
		promos.setDiscountForProduct("Apple", 0.1);
		promos.setDiscountForProduct("Banana", 0.2);
		int expected = 2;
		int actual = promos.getDiscounts().size();
		assertEquals(expected, actual);
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
		double expected = 5.0;
		double actual = promos.getBulkQuantityForProduct("Banana");
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testGetDiscountForProduct() throws InvalidInputException {
		promos.setDiscountForProduct("Banana", 0.2);
		double expected = 0.2;
		double actual = promos.getDiscountForProduct("Banana");
		assertEquals(expected, actual, 0.0001);
	}

}
