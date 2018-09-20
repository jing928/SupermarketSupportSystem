package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

class ProductInventoryTest {

	private ProductInventory productInventory;
	private String name = "Banana";
	private double unitPrice = 2.5;
	private boolean byWeight = true;

	@BeforeEach
	public void setUp() {
		productInventory = new ProductInventory(name, unitPrice, byWeight);
	}

	@Test
	public void testCalculatePriceWhenThereIsNoPromotion() throws InvalidInputException {
		double quantity = 10;
		double expected = quantity * this.unitPrice;
		double actual = productInventory.calculatePrice(quantity);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculatePriceWhenThereIsPromotion() throws InvalidInputException {
		double quantity = 12.5;
		double discount = 0.2;
		double bulkQuantity = 5;
		productInventory.setDiscount(discount);
		productInventory.setBulkQuantity(bulkQuantity);
		double discountedPrice = this.unitPrice * (1 - discount);
		double originalPriceQuantity = quantity % bulkQuantity;
		double discountedPriceQuantity = quantity - originalPriceQuantity;
		double expected = this.unitPrice * originalPriceQuantity + discountedPrice * discountedPriceQuantity; // $26.25
		double actual = productInventory.calculatePrice(quantity);
		assertEquals(expected, actual);
	}

	@Test
	public void testSellProductInvalidInput() throws InvalidInputException, StockLevelException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.sellProduct(-2.5);
		});
	}

	@Test
	public void testSellProductCanThrowExceptionWhenThereIsInsufficientStock()
			throws InvalidInputException, StockLevelException {
		productInventory.setStockLevel(10);
		assertThrows(StockLevelException.class, () -> {
			productInventory.sellProduct(15);
		});
	}

	@Test
	public void testSellProductCanDecreaseStockLevel() throws InvalidInputException, StockLevelException {
		double stockBefore = 20;
		double quantitySold = 10;
		productInventory.setStockLevel(stockBefore);
		productInventory.sellProduct(quantitySold);
		double expected = stockBefore - quantitySold;
		double actual = productInventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetBarCode() {
		String expected = String.valueOf((this.name + this.unitPrice + this.byWeight).toLowerCase().hashCode());
		String actual = productInventory.getItemBarCode();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

	@Test
	public void testGetItemName() {
		String expected = this.name;
		String actual = productInventory.getItemName();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

	@Test
	public void testSetStockLevel() throws InvalidInputException {
		productInventory.setStockLevel(100);
		double expected = 100.0;
		double actual = productInventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.setStockLevel(-10);
		});
	}

	@Test
	public void testIncreaseStockLevel() throws InvalidInputException {
		productInventory.setStockLevel(100);
		productInventory.increaseStockLevel(60);
		double expected = 160.0;
		double actual = productInventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testIncreaseStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.increaseStockLevel(-20);
		});
	}

	@Test
	public void testDecreaseStockLevel() throws InvalidInputException, StockLevelException {
		productInventory.setStockLevel(100);
		productInventory.decreaseStockLevel(60);
		double expected = 40.0;
		double actual = productInventory.getStockLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testDecreaseStockLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.decreaseStockLevel(-17);
		});
	}

	@Test
	public void testDecreaseStockLevelInsufficientInventory() throws StockLevelException, InvalidInputException {
		productInventory.setStockLevel(20);
		assertThrows(StockLevelException.class, () -> {
			productInventory.decreaseStockLevel(25);
		});
	}

	@Test
	public void testSetReplenishLevel() throws InvalidInputException {
		productInventory.setReplenishLevel(60);
		double expected = 60.0;
		double actual = productInventory.getReplenishLevel();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReplenishLevelInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.setReplenishLevel(-8.6);
		});
	}

	@Test
	public void testSetReorderQuantity() throws InvalidInputException {
		productInventory.setReorderQuantity(200);
		double expected = 200.0;
		double actual = productInventory.getReorderQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReorderQuantityInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.setReorderQuantity(-70);
		});
	}

	@Test
	public void testSetBulkQuantity() throws InvalidInputException {
		productInventory.setBulkQuantity(3);
		double expected = 3.0;
		double actual = productInventory.getBulkQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetBulkQuantityInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.setBulkQuantity(-1);
		});
	}

	@Test
	public void testSetDiscount() throws InvalidInputException {
		productInventory.setDiscount(0.2);
		double expected = 0.2;
		double actual = productInventory.getDiscount();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDiscountInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			productInventory.setDiscount(-0.2);
		});
	}

}
