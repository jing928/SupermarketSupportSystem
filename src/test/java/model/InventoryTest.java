package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

class InventoryTest {

	private Inventory inventory;
	private String name = "Banana";
	private double unitPrice = 2.5;
	private boolean byWeight = false;

	@BeforeEach
	public void setUp() {
		inventory = new Product(name, unitPrice, byWeight).getInventory();
	}

	@Test
	public void testCalculatePriceWhenThereIsNoPromotion() throws InvalidInputException {
		double quantity = 10;
		double expected = quantity * this.unitPrice;
		double actual = inventory.calculatePrice(unitPrice, quantity);
		assertEquals(expected, actual);
	}

	@Test
	public void testCalculatePriceWhenThereIsPromotion() throws InvalidInputException {
		double quantity = 12.5;
		double discount = 0.2;
		double bulkQuantity = 5;
		inventory.setDiscount(discount);
		inventory.setBulkQuantity(bulkQuantity);
		double discountedPrice = this.unitPrice * (1 - discount);
		double originalPriceQuantity = quantity % bulkQuantity;
		double discountedPriceQuantity = quantity - originalPriceQuantity;
		double expected = this.unitPrice * originalPriceQuantity + discountedPrice * discountedPriceQuantity; // $26.25
		double actual = inventory.calculatePrice(this.unitPrice, quantity);
		assertEquals(expected, actual);
	}

	@Test
	public void testSellProductCanDecreaseStockLevel() throws InvalidInputException, StockLevelException {
		double stockBefore = 20;
		double quantitySold = 10;
		inventory.setStockLevel(stockBefore);
		inventory.sellProduct(quantitySold);
		double expected = stockBefore - quantitySold;
		double actual = inventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStockLevel() throws InvalidInputException {
		inventory.setStockLevel(100);
		double expected = 100.0;
		double actual = inventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setStockLevel(-10);
		});
	}

	@Test
	public void testIncreaseStockLevel() throws InvalidInputException {
		inventory.setStockLevel(100);
		inventory.increaseStockLevel(60);
		double expected = 160.0;
		double actual = inventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testIncreaseStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.increaseStockLevel(-20);
		});
	}

	@Test
	public void testDecreaseStockLevel() throws InvalidInputException, StockLevelException {
		inventory.setStockLevel(100);
		inventory.decreaseStockLevel(60);
		double expected = 40.0;
		double actual = inventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testDecreaseStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.decreaseStockLevel(-17);
		});
	}

	@Test
	public void testDecreaseStockLevelInsufficientInventory() throws StockLevelException, InvalidInputException {
		inventory.setStockLevel(20);
		assertThrows(StockLevelException.class, () -> {
			inventory.decreaseStockLevel(25);
		});
	}

	@Test
	public void testSetReplenishLevel() throws InvalidInputException {
		inventory.setReplenishLevel(60);
		double expected = 60.0;
		double actual = inventory.getReplenishLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReplenishLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setReplenishLevel(-8.6);
		});
	}

	@Test
	public void testSetReorderQuantity() throws InvalidInputException {
		inventory.setReorderQuantity(200);
		double expected = 200.0;
		double actual = inventory.getReorderQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReorderQuantityInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setReorderQuantity(-70);
		});
	}

	@Test
	public void testSetBulkQuantity() throws InvalidInputException {
		inventory.setBulkQuantity(3);
		double expected = 3.0;
		double actual = inventory.getBulkQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetBulkQuantityInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setBulkQuantity(-1);
		});
	}

	@Test
	public void testSetDiscount() throws InvalidInputException {
		inventory.setDiscount(0.2);
		double expected = 0.2;
		double actual = inventory.getDiscount();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDiscountInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			inventory.setDiscount(-0.2);
		});
	}

	@Test
	public void testGetBulkDiscountInfoWhenNoDiscount() {
		String expected = "Currently there is no bulk discount for Banana.\n";
		String actual = inventory.getBulkDiscountInfo();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

	@Test
	public void testGetBulkDiscountInfoWhenThereIsDiscount() throws InvalidInputException {
		inventory.setBulkQuantity(5);
		inventory.setDiscount(0.2);
		String expected = "For every 5 units of Banana, you get 20.00% off the original price.\n";
		String actual = inventory.getBulkDiscountInfo();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

	@Test
	public void testToString() {
		String expected = "Product Name: Banana (Barcode: -526682705) | Stock Level: 0.00 | Replenish Level: 0.00 | Supplier: none\n";
		String actual = inventory.toString();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

}
