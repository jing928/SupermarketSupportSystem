package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

public class SalesLineItemTest {

	private SalesLineItem lineItem;
	private ProductInventory item;
	private double unitPrice = 3.0;
	private double quantity = 6.0;

	@BeforeEach
	public void setUp() throws Exception {
		item = new ProductInventory("Apple", this.unitPrice, false);
		lineItem = new SalesLineItem(this.item, this.quantity);
	}

	@Test
	public void testGetPrice() throws InvalidInputException {
		double expected = this.item.calculatePrice(this.quantity);
		double actual = this.lineItem.getPrice();
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
