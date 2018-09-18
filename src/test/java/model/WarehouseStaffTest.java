package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import exception.InvalidInputException;


//TODO
class WarehouseStaffTest {

	@Test
	void testReplenishStockLevel() throws InvalidInputException {
		// Fixtures
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("aaa", 0.0);
		// Actions
		inventory.increaseStockLevelForProduct("aaa", 2.0);
		// Actual Result
		double actualQuantity = inventory.getReplenishLevelForProduct("aaa");
		// Expected Result
		double exceptedQuantity = 2.0;
		// Assertions
		assertEquals(actualQuantity, exceptedQuantity);

	}
}