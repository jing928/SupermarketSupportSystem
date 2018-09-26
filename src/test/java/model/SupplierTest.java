package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupplierTest {

	private Supplier supplier;
	private String supplierName = "abc";
	private Location address = new Location("11", "Haha Road", "6", "Melbourne", "3000");
	private String phone = "0412345678";

	@BeforeEach
	public void setUp() throws Exception {
		supplier = new Supplier(supplierName, address, phone);
	}

	@Test
	public void testAddProduct() {
		// Fixtures
		Inventory product1 = new Product("acc", 2.0, true).getInventory();
		// Actions
		supplier.addProduct(product1);
		// Actual Result
		boolean actualProductContain = supplier.getProducts().contains(product1);
		// Expected Result
		boolean expectedProductContain = true;
		// Assertions
		assertEquals(actualProductContain, expectedProductContain);

	}

	@Test
	public void testAddPhoneNumber() {
		// Fixtures
		String supplierPhoneNumber = "000";
		// Actions
		supplier.setPhoneNum(supplierPhoneNumber);
		// Actual Result
		boolean actualPhoneNumber = supplier.getPhoneNum().contains(supplierPhoneNumber);
		// Expected Result
		boolean exceptedPhoneNumber = true;
		// Assertions
		assertEquals(actualPhoneNumber, exceptedPhoneNumber);

	}

	@Test
	public void testAddNullPhoneNumber() {
		// Fixtures
		String supplierPhoneNumber = null;
		// Actions
		supplier.setPhoneNum(supplierPhoneNumber);
		// Actual Result
		boolean actualPhoneNumber = supplier.getPhoneNum().contains(supplierPhoneNumber);
		// Expected Result
		boolean exceptedPhoneNumber = false;
		// Assertions
		assertEquals(actualPhoneNumber, exceptedPhoneNumber);
	}

}
