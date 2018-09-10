package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaleTest {
	private Date saleDate;
	private Customer customer;
	private Sale sale;
	private Product product;

	@BeforeEach
	public void setUp() throws Exception {
		customer = new Customer("defe", "fsdf");
		saleDate = new Date();
		sale = new Sale(customer, saleDate);
		product = new Product("apple", 9.9, true);
	}

	@Test
	public void testSale() {
		assertTrue(sale.getCustomer().equals(customer));
		assertTrue(sale.getSaleDate().equals(saleDate));
	}

	@Test
	public void testAddLineItem() {
		sale.addLineItem(product, 2.5);
		assertTrue(sale.getSalesLineItems().get(0).getQuantity() == 2.5);// ?
	}

}
