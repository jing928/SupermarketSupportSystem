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
	private String phone = "0412345678";
	private String id = "123";
	private String name = "Jack";
	private Location address = new Location("11", "Haha Road", "6", "Melbourne", "3000");
	private Customer customer;
	private Sale sale;
	private String name1 = "Apple";
	private Product item1;
	private double price1 = 3.0;
	private double quant1 = 2;
	private double stock1 = 10;
	private String name2 = "Banana";
	private Product item2;
	private double price2 = 2.5;
	private double quant2 = 3.5;
	private double stock2 = 10;

	@BeforeEach
	public void setUp() throws Exception {
		item1 = new Product(name1, price1, false);
		item2 = new Product(name2, price2, true);
		customer = new Customer(id, name, phone, address);
		sale = new Sale(customer, saleDateTime);
		item1.getInventory().setStockLevel(stock1);
		item2.getInventory().setStockLevel(stock2);
		sale.addLineItem(item1, quant1);
		sale.addLineItem(item2, quant2);
	}

	@Test
	public void testAddLineItem() throws InvalidInputException, StockLevelException {
		Product item3 = new Product("Grape", 5, true);
		item3.getInventory().setStockLevel(5);
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
		double expected = price1 * quant1 + price2 * quant2;
		double actual = sale.getTotalPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testFinalizeSaleCanDecreaseStockLevels() throws InvalidInputException, StockLevelException {
		sale.finalizeSale();
		double expected1 = stock1 - quant1;
		double actual1 = item1.getInventory().getStockLevel();
		assertEquals(expected1, actual1);
		double expected2 = stock2 - quant2;
		double actual2 = item2.getInventory().getStockLevel();
		assertEquals(expected2, actual2);
	}

}
