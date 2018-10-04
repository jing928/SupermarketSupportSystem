package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidInputException;

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
	public void testGenerateBarCodeCanGenerateSameBarCodeWithSameInputs() {
		String name = "banana";
		double price = 2.5;
		boolean byWeight = true;
		Product p1 = new Product(name, price, byWeight);
		Product p2 = new Product(name, price, byWeight);
		String p1BarCode = p1.getBarCode();
		String p2BarCode = p2.getBarCode();

		boolean isSame = p1BarCode.equals(p2BarCode);

		assertTrue(isSame);
	}

	@Test
	public void testGenerateBarCodeCanGenerateDifferentBarCodeWithDifferentInputs() {
		Product p1 = new Product("Apple", 2.8, false);
		Product p2 = new Product("Banana", 2.5, true);
		String p1BarCode = p1.getBarCode();
		String p2BarCode = p2.getBarCode();

		boolean isSame = p1BarCode.equals(p2BarCode);

		assertFalse(isSame);
	}

	@Test
	public void testProduct() {
		assertEquals(name, product.getName());
		assertTrue(product.getUnitPrice() == unitPrice);
		assertEquals(byweight, product.isByWeight());
	}

	@Test
	public void testSetName() {
		product.setName("orange");
		assertEquals("orange", product.getName());
	}

	@Test
	public void testSetUnitPrice() throws InvalidInputException {
		product.setUnitPrice(6.6);
		assertTrue(product.getUnitPrice() == 6.6);
	}

	@Test
	public void testSetByweight() {
		product.setByWeight(true);
		assertTrue(product.isByWeight());
		product.setByWeight(false);
		assertFalse(product.isByWeight());
	}
	
	@Test
	public void testToStringPerKG() {
		String expected = "The price for apple is $9.90 per kg.\n";
		String actual = product.toString();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}
	
	@Test
	public void testToStringEach() {
		product.setByWeight(false);
		String expected = "The price for apple is $9.90 each.\n";
		String actual = product.toString();
		boolean isSame = expected.equals(actual);
		assertTrue(isSame);
	}

}
