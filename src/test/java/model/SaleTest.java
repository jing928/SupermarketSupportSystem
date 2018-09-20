package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

public class SaleTest {
	private LocalDateTime saleDateTime = LocalDateTime.of(2018, Month.of(9), 28, 9, 28, 0);
	private Customer customer = new Customer("123", "John Smith");
	private Sale sale;
	private String name1 = "Apple";
	private ProductInventory item1;
	private double stock1 = 10;
	private double quant1 = 2;
	private String name2 = "Banana";
	private ProductInventory item2;
	private double quant2 = 3.5;
	private double stock2 = 10;

	@BeforeEach
	public void setUp() throws Exception {
		item1 = new ProductInventory(name1, 3.0, false);
		item2 = new ProductInventory(name2, 2.5, true);
		sale = new Sale(customer, saleDateTime);
		item1.setStockLevel(stock1);
		item2.setStockLevel(stock2);
		sale.addLineItem(item1, quant1);
		sale.addLineItem(item2, quant2);
	}

	@Test
	public void testAddLineItem() throws InvalidInputException {
		ProductInventory item3 = new ProductInventory("Grape", 5, true);
		sale.addLineItem(item3, 1);
		int expected = 3;
		int actual = sale.getLineItems().size();
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateLineItem() throws InvalidInputException {
		double additionalQuantity = 3;
		sale.updateLineItem(name1, additionalQuantity);
		double expected = quant1 + additionalQuantity;
		double actual = sale.getLineItems().get(name1).getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateLineItemInvalidInput() throws InvalidInputException {
		assertThrows(InvalidInputException.class, () -> {
			sale.updateLineItem(name1, -2);
		});
	}

	@Test
	public void testGetTotalPrice() {
		double expected = item1.calculatePrice(quant1) + item2.calculatePrice(quant2);
		double actual = sale.getTotalPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testFinalizeSaleCanDecreaseStockLevels() throws InvalidInputException, StockLevelException {
		sale.finalizeSale();
		double expected1 = stock1 - quant1;
		double actual1 = item1.getStockLevel();
		assertEquals(expected1, actual1);
		double expected2 = stock2 - quant2;
		double actual2 = item2.getStockLevel();
		assertEquals(expected2, actual2);
	}

}
