package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesLineItemTest {
	private Product item;
	private String itemName = "apple";
	private double quantity = 2.5;
	private double price = 10;
    private SalesLineItem saleslineitem;
    
    @BeforeEach
	public void setUp() throws Exception {
    	saleslineitem = new SalesLineItem(itemName, quantity, price, item);
    }
    
    @Test
    public void testSalesLineItem() {
    	assertEquals(itemName, saleslineitem.getItemName());
    	assertTrue(saleslineitem.getQuantity()==quantity);
    	assertTrue(saleslineitem.getPrice()==price);
    }
	
    

    @Test
	public void testSetItem() {
    	Product item2 = new Product("fgf", 453,true);
    	saleslineitem.setItem(item2);
    	assertTrue(saleslineitem.getItem().equals(item2));
    	//assertEquals(item2,saleslineitem.getItem());
	}
    
    
    
    
    @Test
	public void testSetItemName() {
    	saleslineitem.setItemName("orange");
		assertEquals("orange",saleslineitem.getItemName());
	}
	
    @Test
    public void testSetQuantity() {
    	saleslineitem.setQuantity(9.9);
    	assertTrue(saleslineitem.getQuantity()==9.9);
    }
	
    @Test
    public void testSetPrice() {
    	saleslineitem.setPrice(6.6);
    	assertTrue(saleslineitem.getPrice()==6.6);
    }
	
	
	
	
	
	
	
	
	
}
