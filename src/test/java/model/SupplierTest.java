package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SupplierTest {
	private Supplier supplier;
	private String supplierId="111";
	private String supplierName="abc";

	@Before
	public void setUp() throws Exception {
		supplier=new Supplier(supplierId,supplierName);
	}

	

	@Test
	public void testAddSupplierLocation(){
		Location location1=new Location("a","b","c","d","e","f","g");
	    assertTrue(supplier.addSupplierLocation(location1));
		assertFalse(supplier.addSupplierProducts(null));
	}

	@Test
	public void testAddSupplierProducts() {
		Product product1=new Product();
		assertTrue(supplier.addSupplierProducts(product1));
		assertFalse(supplier.addSupplierProducts(null));
		
	}

	@Test
	public void testAddPhoneNumber() {
		assertTrue(supplier.addPhoneNumber("1234567"));
		assertFalse(supplier.addPhoneNumber("1234567"));
		assertFalse(supplier.addPhoneNumber(null));
		assertTrue(supplier.getSupplierPhoneNumber().size()==1);
		assertEquals("1234567",supplier.getSupplierPhoneNumber().get(0));
		supplier.addPhoneNumber("7654321");
		assertTrue(supplier.getSupplierPhoneNumber().size()==2);
		assertEquals("7654321", supplier.getSupplierPhoneNumber().get(1));
	}



}
