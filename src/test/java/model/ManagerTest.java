package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

	Manager manager;
	Product product;

	@BeforeEach
	public void setUp() throws Exception {
		manager = new Manager("M001", "John", 'M');
	}

	@Test
	public void testOverridePrice() {
		// Fixtures
		product = new Product("aaa", 10.0, true);
		// Actions
		manager.overridePrice(product, 12.0);
		// Actual Result
		double actualPrice = product.getUnitPrice();
		// Expected Result
		double exceptedPrice = 12.0;
		// Assertions
		assertEquals(actualPrice, exceptedPrice);

	}

}
