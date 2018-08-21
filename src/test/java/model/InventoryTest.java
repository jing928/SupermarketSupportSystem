package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void testSetStockLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.setStockLevelForProduct("Banana", 200);
		assertEquals(2, inventory.getStockLevels().size());
	}

	@Test(expected = InvalidInputException.class)
	public void testSetStockLevelForProductInvalidInput() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", -10);
	}

	@Test
	public void testGetStockLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.setStockLevelForProduct("Banana", 200);
		assertEquals(100, inventory.getStockLevelForProduct("Apple"), 0.0001);
		assertEquals(200, inventory.getStockLevelForProduct("Banana"), 0.0001);
	}

	@Test
	public void testIncreaseStockLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.increaseStockLevelForProduct("Apple", 60);
		assertEquals(160, inventory.getStockLevelForProduct("Apple"), 0.0001);
	}

	@Test(expected = InvalidInputException.class)
	public void testIncreaseStockLevelForProductInvalidInput() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.increaseStockLevelForProduct("Apple", -20);
	}

	@Test
	public void testDecreaseStockLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.decreaseStockLevelForProduct("Apple", 60);
		assertEquals(40, inventory.getStockLevelForProduct("Apple"), 0.0001);
	}

	@Test(expected = InvalidInputException.class)
	public void testDecreaseStockLevelForProductInvalidInput() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.decreaseStockLevelForProduct("Apple", -17);
	}

	@Test
	public void testSetReplenishLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReplenishLevelForProduct("Apple", 50);
		inventory.setReplenishLevelForProduct("Banana", 60);
		assertEquals(2, inventory.getReplenishLevels().size());
	}

	@Test(expected = InvalidInputException.class)
	public void testSetReplenishLevelForProductInvalidInput() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReplenishLevelForProduct("Apple", -8.6);
	}

	@Test
	public void testGetReplenishLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReplenishLevelForProduct("Apple", 50);
		inventory.setReplenishLevelForProduct("Banana", 60);
		assertEquals(50, inventory.getReplenishLevelForProduct("Apple"), 0.0001);
		assertEquals(60, inventory.getReplenishLevelForProduct("Banana"), 0.0001);
	}

	@Test
	public void testSetReorderQuantityForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReorderQuantityForProduct("Apple", 100);
		inventory.setReorderQuantityForProduct("Banana", 200);
		assertEquals(2, inventory.getReorderQuantities().size());
	}

	@Test(expected = InvalidInputException.class)
	public void testSetReorderQuantityForProductInvalidInput() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReorderQuantityForProduct("Apple", -70);
	}

	@Test
	public void testGetReorderQuantityForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReorderQuantityForProduct("Apple", 100);
		inventory.setReorderQuantityForProduct("Banana", 200);
		assertEquals(100, inventory.getReorderQuantityForProduct("Apple"), 0.0001);
		assertEquals(200, inventory.getReorderQuantityForProduct("Banana"), 0.0001);
	}

}
