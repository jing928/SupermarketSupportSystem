package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exception.InvalidInputException;

//TODO
class WarehouseStaffTest {

	@Test
	void testReplenishStockLevel() throws InvalidInputException {
		// Fixtures
		ProductInventory inventory = new ProductInventory("Apple", 3, false);
		// Actions
		inventory.increaseStockLevel(2.0);
		// Actual Result
		double actualQuantity = inventory.getReplenishLevel();
		// Expected Result
		double exceptedQuantity = 2.0;
		// Assertions
		assertEquals(actualQuantity, exceptedQuantity);

	}
}