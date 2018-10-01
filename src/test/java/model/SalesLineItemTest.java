package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

public class SalesLineItemTest {

	private SalesLineItem lineItem;
	private Product item;
	private double unitPrice = 3.0;
	private double quantity = 6.0;

	@BeforeEach
	public void setUp() throws Exception {
		item = new Product("Apple", this.unitPrice, false);
		item.getInventory().setStockLevel(10);
		lineItem = new SalesLineItem(this.item, this.quantity);
	}

	@Test
	public void testSalesLineItemInvalidInput() {
		assertThrows(InvalidInputException.class, () -> {
			lineItem = new SalesLineItem(this.item, 0);
		});
	}

	@Test
	public void testGetPrice() {
		double expected = unitPrice * quantity;
		double actual = this.lineItem.getSubTotalPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetQuantity() throws InvalidInputException {
		double quantity = 10;
		lineItem.setQuantity(quantity);
		double expected = quantity;
		double actual = lineItem.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetQuantityInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			lineItem.setQuantity(-5);
		});
	}

}
