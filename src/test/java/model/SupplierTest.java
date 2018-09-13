package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupplierTest {

	private Supplier supplier;
	private String supplierId = "111";
	private String supplierName = "abc";
	ArrayList<Location> supplierLocations;

	@BeforeEach
	public void setUp() throws Exception {
		supplier = new Supplier(supplierId, supplierName);
		supplierLocations = new ArrayList<>();
	}

	@Test
	public void testAddSupplierLocation() {
		// Fixtures
		Location location1 = new Location("a", "b", "c", "d", "e", "f", "g");
		// Actions
		supplier.addSupplierLocation(location1);
		// Actual Result
		boolean actualLocationContain = supplier.getSupplierLocation().contains(location1);
		// Expected Result
		boolean expectedLocationContain = true;
		// Assertions
		assertEquals(expectedLocationContain, actualLocationContain);

	}

	@Test
	public void testAddSupplierProducts() {
		// Fixtures
		Product product1 = new Product("acc", 2.0, true);
		// Actions
		supplier.addSupplierProducts(product1);
		// Actual Result
		boolean actualProductContain = supplier.getSupplierProducts().contains(product1);
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
		supplier.addPhoneNumber(supplierPhoneNumber);
		// Actual Result
		boolean actualPhoneNumber = supplier.getSupplierPhoneNumber().contains(supplierPhoneNumber);
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
		supplier.addPhoneNumber(supplierPhoneNumber);
		// Actual Result
		boolean actualPhoneNumber = supplier.getSupplierPhoneNumber().contains(supplierPhoneNumber);
		// Expected Result
		boolean exceptedPhoneNumber = false;
		// Assertions
		assertEquals(actualPhoneNumber, exceptedPhoneNumber);
	}

}
