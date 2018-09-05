package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
	
	Manager manager1;

	@Before
	public void setUp() throws Exception {
		manager1=new Manager();
	}
	
	@Test
	public void testOverridePrice() {
		Product product1= new Product();
		assertTrue(manager1.overridePrice(product1, 11));
		assertFalse(manager1.overridePrice(product1, -1));
	}

	@Test
	public void testModifyPromotion() {
		Product product1= new Product();
		assertTrue(manager1.modifyPromotion(product1, 5, 0.3));
		assertFalse(manager1.modifyPromotion(product1, -1, 0.3));
		assertFalse(manager1.modifyPromotion(product1, 0, 0.3));
		assertFalse(manager1.modifyPromotion(product1, 5, -2));
		assertFalse(manager1.modifyPromotion(product1, 5, 1));
		assertFalse(manager1.modifyPromotion(product1, 5, 1.3));
		
	}

}
