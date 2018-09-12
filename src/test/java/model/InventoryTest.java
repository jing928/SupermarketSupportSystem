package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

	private Inventory inventory;

	@BeforeEach
	public void setUp() {
		inventory = new Inventory();
	}

	@Test
	public void testSetStockLevelForProduct() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.setStockLevelForProduct("Banana", 200);
		int expected = 2;
		int actual = inventory.getStockLevels().size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStockLevelForProductInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setStockLevelForProduct("Apple", -10);
		});
	}

	@Test
	public void testGetStockLevelForProduct() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		double expected = 100.0;
		double actual = inventory.getStockLevelForProduct("Apple");
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testIncreaseStockLevelForProduct() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.increaseStockLevelForProduct("Apple", 60);
		double expected = 160.0;
		double actual = inventory.getStockLevelForProduct("Apple");
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testIncreaseStockLevelForProductInvalidInput() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		assertThrows(InvalidInputException.class, () -> {
			inventory.increaseStockLevelForProduct("Apple", -20);
		});
	}

	@Test
	public void testDecreaseStockLevelForProduct() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		inventory.decreaseStockLevelForProduct("Apple", 60);
		double expected = 40;
		double actual = inventory.getStockLevelForProduct("Apple");
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testDecreaseStockLevelForProductInvalidInput() throws InvalidInputException {
		inventory.setStockLevelForProduct("Apple", 100);
		assertThrows(InvalidInputException.class, () -> {
			inventory.decreaseStockLevelForProduct("Apple", -17);
		});
	}

	@Test
	public void testSetReplenishLevelForProduct() throws InvalidInputException {
		inventory.setReplenishLevelForProduct("Apple", 50);
		inventory.setReplenishLevelForProduct("Banana", 60);
		int expected = 2;
		int actual = inventory.getReplenishLevels().size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReplenishLevelForProductInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setReplenishLevelForProduct("Apple", -8.6);
		});
	}

	@Test
	public void testGetReplenishLevelForProduct() throws InvalidInputException {
		Inventory inventory = new Inventory();
		inventory.setReplenishLevelForProduct("Apple", 50);
		double expected = 50.0;
		double actual = inventory.getReplenishLevelForProduct("Apple");
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void testSetReorderQuantityForProduct() throws InvalidInputException {
		inventory.setReorderQuantityForProduct("Apple", 100);
		inventory.setReorderQuantityForProduct("Banana", 200);
		int expected = 2;
		int actual = inventory.getReorderQuantities().size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReorderQuantityForProductInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setReorderQuantityForProduct("Apple", -70);
		});
	}

	@Test
	public void testGetReorderQuantityForProduct() throws InvalidInputException {
		inventory.setReorderQuantityForProduct("Apple", 100);
		double expected = 100.0;
		double actual = inventory.getReorderQuantityForProduct("Apple");
		assertEquals(expected, actual, 0.0001);
	}

}
