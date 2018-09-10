package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
	private Product product;
	private String name = "apple";
	private double unitPrice = 9.9;
	private boolean byweight = true;

	@BeforeEach
	public void setUp() throws Exception {
		product = new Product(name, unitPrice, byweight);
	}

	@Test
    public void testProduct() {
    	assertEquals(name,product.getName());
    	assertTrue(product.getUnitPrice()==unitPrice);
    	assertEquals(byweight,product.isByweight());
    }

	@Test
	public void testSetName() {
		product.setName("orange");
		assertEquals("orange", product.getName());
	}

	@Test
	public void testSetUnitPrice() {
		product.setUnitPrice(6.6);
		assertTrue(product.getUnitPrice() == 6.6);
	}

	@Test
	public void testSetByweight() {
		product.setByweight(true);
		assertTrue(product.isByweight());
		product.setByweight(false);
		assertFalse(product.isByweight());
	}

}
